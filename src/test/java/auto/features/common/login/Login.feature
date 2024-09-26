Feature: Login

  @login
  Scenario: Login get token c1
    Given url 'https://bookstore.toolsqa.com/Account/v1/GenerateToken'
    * configure ssl = true
    And request

    """
      {
      "userName": "demo",
      "password": "Demo@2024"
      }
    """
    * method POST
    * status 200
    * print response
    * def accessToken = response.token
    * print 'accessToken=>>>>> ',accessToken

  @loginOptimize
  Scenario: Login get token c2
    Given url 'https://bookstore.toolsqa.com/Account/v1/GenerateToken'

    * def jsonBody = read('classpath:data/common/login.json')
    * print jsonBody
    And request jsonBody

    * method POST
    * status 200
    * print response
    * def accessToken = response.token
    * print 'accessToken=>>>>> ',accessToken

  @loginWithParam
  Scenario: Login get token c2
    Given url 'https://bookstore.toolsqa.com/Account/v1/GenerateToken'

    And request
    """
      {
      "userName": "#(username)",
      "password": "#(password)"
      }
    """
    * method POST
    * status 200
    * print response
    * def accessToken = response.token
    * print 'accessToken=>>>>> ',accessToken
