Feature: add book

  Background:

  @reuse
  Scenario: reuse
#    #  src/test/java/auto/features/common/login/Login.feature
#    * def username = "demo11"
#    * def password = "demo1111"
#    * call read('classpath:auto/features/common/login/Login.feature@login')

    * def login = call read('classpath:auto/features/common/login/Login.feature@login')
    * def accessToken11 = login.accessToken
#
#
#
#    * def token1223 = login.accessToken
#
#    * print 'token1223=>>>',token1223
#    Given url 'https://bookstore.toolsqa.com/Account/v1/GenerateToken'
#    And request
#    """
#      {
#      "userName": "demo",
#      "password": "Demo@2024"
#      }
#    """
#    * method POST
#    * status 200
#    * print response
#    * def accessToken = response.token

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




#    """
#    {
#            "isbn": "9781449331818",
#            "title": "Learning JavaScript Design Patterns",
#            "subTitle": "A JavaScript and jQuery Developer's Guide",
#            "author": "Addy Osmani",
#            "publish_date": "2020-06-04T09:11:40.000Z",
#            "publisher": "O'Reilly Media",
#            "pages": 254,
#            "description": "With Learning JavaScript Design Patterns, you'll learn how to write beautiful, structured, and maintainable JavaScript by applying classical and modern design patterns to the language. If you want to keep your code efficient, more manageable, and up-to-da",
#            "website": "http://www.addyosmani.com/resources/essentialjsdesignpatterns/book/"
#        }
#    """

