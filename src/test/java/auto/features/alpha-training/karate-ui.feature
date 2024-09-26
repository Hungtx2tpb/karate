Feature: karate ui demo

  Scenario: karate ui
    * call read ('classpath:data/locators/loginWeb.json')
    And configure driver = { type: 'chrome', addOptions: ["--remote-allow-origins=*", "--disable-save-password-bubble", "--incognito" ]}
    And driver baseUrlWeb
    When maximize()
    * delay(10000)
    And waitFor(loginWeb.txtSearch)
    * delay(10000)
    And input(loginWeb.txtSearch, ['Karate UI',Key.ENTER])
    * delay(10000)
    And waitFor("//h3[text()='Karate UI']").click()
    * delay(10000)
    Then match driver.title == 'Karate UI | Karate'
    * screenshot()
    * delay(10000)

