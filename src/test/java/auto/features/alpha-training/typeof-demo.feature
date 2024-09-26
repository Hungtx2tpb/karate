Feature: typeof

  @typeof
  Scenario: typeof
    * def jsonBody =
     """{
      "userName":"#(user)",
      "passWord":"#(pass)"
      }
      """
    * print '========jsonBody:', jsonBody
    * if (typeof user == 'undefined') karate.remove('jsonBody', '$.userName')
    #    user define
    * if (typeof user != 'undefined') karate.set('jsonBody', '$.userName',user)

    * if (typeof pass == 'undefined') karate.remove('jsonBody', '$.passWord')
    #    pass define
    * if (typeof pass != 'undefined') karate.set('jsonBody', '$.passWord',pass)
    * print '========jsonBody:', jsonBody

  @typeofTest
  Scenario: Test typeof
    * call read('classpath:auto/features/alpha-training/typeof-demo.feature@typeof'){user:"acb", pass:"xyz"}
    * call read('classpath:auto/features/alpha-training/typeof-demo.feature@typeof')