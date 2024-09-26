Feature: call once

  Background: Test

  @callonce
  Scenario: call once 1 user demo

    * def login = callonce read('classpath:auto/features/common/login/Login.feature@login')
    * def accessToken11 = login.accessToken

#    get user info
    Given url baseUrl + '/Account/v1/User/4ad35d66-2847-4d87-8de7-43449653b67e'
    And header Authorization = "Bearer " + accessToken11
    * method get
    Then status 200
    Then match response ==
    """
        {
      "userId": "#string",
      "username": "#string",
      "books": "#array"
    }
    """

  @callonce
  Scenario: call once other user 1 TuyetLT676

    * def login = callonce read('classpath:auto/features/common/login/Login.feature@loginWithParam'){username:"TuyetLT676", password:"Tuyet@6789"}
#    * def login = call read('classpath:auto/features/common/login/Login.feature@login')
    * def accessToken11 = login.accessToken

#    get user info
    Given url baseUrl + '/Account/v1/User/f6130cbd-e373-418a-8f2a-b3b272c412b4'
#    Given url baseUrl + '/Account/v1/User/4ad35d66-2847-4d87-8de7-43449653b67e'
    And header Authorization = "Bearer " + accessToken11
    * method get
    Then status 200
    Then match response ==
    """
        {
      "userId": "#string",
      "username": "#string",
      "books": "#array"
    }
    """

  Scenario: call once 2 user demo

    * def login = callonce read('classpath:auto/features/common/login/Login.feature@login')
    * def accessToken11 = login.accessToken

#    get user info
    Given url baseUrl + '/Account/v1/User/4ad35d66-2847-4d87-8de7-43449653b67e'
    And header Authorization = "Bearer " + accessToken11
    * method get
    Then status 200
    Then match response ==
    """
        {
      "userId": "#string",
      "username": "#string",
      "books": "#array"
    }
    """

  Scenario: call once 3 user demo

    * def login = callonce read('classpath:auto/features/common/login/Login.feature@login')
    * def accessToken11 = login.accessToken

#    get user info
    Given url baseUrl + '/Account/v1/User/4ad35d66-2847-4d87-8de7-43449653b67e'
    And header Authorization = "Bearer " + accessToken11
    * method get
    Then status 200
    Then match response ==
    """
        {
      "userId": "#string",
      "username": "#string",
      "books": "#array"
    }
    """


  @callonce
  Scenario: call once other user 2 TuyetLT676

    * def login = callonce read('classpath:auto/features/common/login/Login.feature@loginWithParam'){username:"TuyetLT676", password:"Tuyet@6789"}
#    * def login = call read('classpath:auto/features/common/login/Login.feature@login')
    * def accessToken11 = login.accessToken

#    get user info
    Given url baseUrl + '/Account/v1/User/f6130cbd-e373-418a-8f2a-b3b272c412b4'
#    Given url baseUrl + '/Account/v1/User/4ad35d66-2847-4d87-8de7-43449653b67e'
    And header Authorization = "Bearer " + accessToken11
    * method get
    Then status 200
    Then match response ==
    """
        {
      "userId": "#string",
      "username": "#string",
      "books": "#array"
    }
    """