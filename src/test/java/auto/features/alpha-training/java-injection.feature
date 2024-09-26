Feature: Login

  @login
  Scenario: Login get token
    Given url 'https://bookstore.toolsqa.com/Account/v1/GenerateToken'
    And request
    """
      {
      "userName": "demo",
      "password": "Demo@2024"
      }
    """
    * method post
    * status 200
    * print response
    * def accessToken = response.access_token

    * def Helper = Java.type('auto.utils.external.Helper')
    * def helper = new Helper
    * def userID = helper.getRandomString(10)
    * print userID
    Given url 'https://bookstore.toolsqa.com/Account/v1/User/'+ userID
    And header Authorization = "Bearer " + accessToken
    * method get
    Then status 401

  @create-user
  Scenario: create user
    * def Helper = Java.type('auto.utils.external.Helper')
    * def helper = new Helper
    * def user = 'alpha' + helper.getRandomString(10)
    * def pass = 'Alpha@1' + helper.getRandomString(3)
    * print 'user=>>>', user
    * print 'pass=>>>', pass

    Given url 'https://bookstore.toolsqa.com/Account/v1/User'
    And request
  """
  {
    "userName": "#(user)",
    "password": "#(pass)"
}
 """
    And method POST
    And status 201
    And match response.username == user
    And match response ==
    """
    {
    "userID": "#string",
    "username": "#(user)",
    "books": []
  }
    """


#    buổi 1

