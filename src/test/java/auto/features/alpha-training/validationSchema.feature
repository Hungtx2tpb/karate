Feature: add book

  @Schema
  Scenario: validation Schema
    * def login = call read('classpath:auto/features/common/login/Login.feature@login')
    * def token = login.accessToken
    * print token

    #get user info
    Given url baseUrl + '/Account/v1/User/4ad35d66-2847-4d87-8de7-43449653b67e'
    And header Authorization = "Bearer " + token
    * method get
    Then status 200
    * def schema =
    """
        {
      "userId": "#number",
      "username": "#string",
      "books": "#array"
    }
    """

    Then match response == schema

  @Schema11111111
  Scenario: validation Schema has time
    Given url baseUrl + '/BookStore/v1/Books'
    * method get
    Then status 200

#    * def isValidTime = call read('classpath:auto/utils/internal/timeValidator.js')

#    Then match each response.books ==
#   """
#      {
#              "isbn": "#string",
#              "title": "#string",
#              "subTitle": "#string",
#              "author": "#string",
#              "publish_date": "#string",
#              "publisher": "#string",
#              "pages": "#number",
#              "description": "#string",
#              "website": "#string"
#          }
#      """

#    Then match response.books[0] ==
#     """
#        {
#                "isbn": "#string",
#                "title": "#string",
#                "subTitle": "#string",
#                "author": "#string",
#                "publish_date": "#string",
#                "publisher": "#string",
#                "pages": "#number",
#                "description": "#string",
#                "website": "#string"
#            }
#        """

#  Then match each response.books.isbn ==
#       """
#          {
#                  "isbn": "#string"
#              }
#          """

    * match each response.books[*].isbn == "#string"
    * match response.books[0].isbn == "#string"



