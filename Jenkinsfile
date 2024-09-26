pipeline {
    agent {
        label('agent-qe-02')
    }

    options {
        skipDefaultCheckout(true)
    }

    environment {
        MAVEN_HOME = '/usr/local/Cellar/maven/3.8.1/'
        PATH = "$PATH:$MAVEN_HOME/bin"
        MAVEN_OPTS = "-Xss10M"
        TEAMS_URL = "https://domain"
    }

    stages {
        stage("Clean Workspace before Build and CheckoutSCM") {
            steps {
                cleanWs()
                checkout scm
            }
        }
        // Karate
        stage('Run Karate Automation Test') {
            steps {
                script {
                    def RUNTEST_STATUS = sh(script: "mvn clean test \"-Dkarate.options=--tags @${params.KarateTags} --tags ~@ignore --tags ~@NOT_READY\" -Dtest=TestRunner -Dkarate.env=${params.Environment}", returnStatus: true)
                    echo "${RUNTEST_STATUS}"
                }
            }
        }
        stage('Summary Karate Report to Jira') {
            steps {
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "${params.CredentialsID}", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                    script {
                        sh "cp added.json target/cucumber-html-reports/added.json"
                        sh """sed -i "s/__NAME__/${params.KarateXrayExecution}/" target/cucumber-html-reports/added.json"""
                        sh "java -jar SetExecutionXrayForKarate.jar"
                        if ( "${params.KarateXrayExecution}" == "" ){
                            echo "XrayExecution is empty"
                        } else {
                            sh "chmod +x xray-config.sh"
                            sh "./xray-config.sh ${USERNAME} ${PASSWORD}"
                        }   
                    }
                }
            }
        }
        stage('Configuration Jira Summary') {
            when {
                expression { return params.enableJiraConfig }
            }
            steps {
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: "${params.CredentialsID}", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                    script {
                        sh "chmod +x jira-config.sh"
                        sh "./jira-config.sh ${USERNAME} ${PASSWORD} ${params.JiraProject}"
                    }
                }
            }
        }
        stage('Summary Karate Report to Jenkins Master') {
            steps {
                sh """ssh root@10.101.11.54 "mkdir -p /var/lib/jenkins/ptlogs/${JOB_NAME}-Karate-${BUILD_NUMBER}" """
                sh "scp -r target/cucumber-html-reports/* root@10.101.11.54:/var/lib/jenkins/ptlogs/${JOB_NAME}-Karate-${BUILD_NUMBER}"
            }
        }
        stage('HTML Karate Publisher') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-html-reports',
                    reportFiles: 'overview-features.html',
                    reportName: 'HTML Report Karate'
                ])
            }
        }
    }
    post {
        always {
            script {
                def reportLink = "${env.BUILD_URL}/HTML_20Report_20Karate/"
                def KarateMessage = " **Completed Karate Tests Please check the below reports**  \n" +
                    " [Karate Reports Link](${reportLink}) "
                office365ConnectorSend(
                    webhookUrl: "${env.TEAMS_URL}",
                message: KarateMessage,
                    status: "**Karate Tests Completed with Build No ${env.BUILD_ID}**")
            }
        }
    }
}
