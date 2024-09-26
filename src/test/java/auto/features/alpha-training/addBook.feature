Feature: add book

  @addBook
  Scenario: add book
    Given url 'https://bookstore.toolsqa.com/Account/v1/GenerateToken'
    And request
    """
      {
      "userName": "demo",
      "password": "demo@2024"
      }
    """
    * method post
    * status 200
    * print response
    * def accessToken = response.token
    * print 'accessToken=>>>>> ',accessToken

    # add books
    Given url 'https://bookstore.toolsqa.com/BookStore/v1/Books'
    And header Authorization = "Bearer " + accessToken
    And request
    """
        {
            "userId": "#(userId)",
            "collectionOfIsbns": [
                {
                    "isbn": "#(isbn)"
                }
            ]
        }
    """
    * configure cookies = null
    * method post
    Then status 201
    # delete book
    Given url 'https://bookstore.toolsqa.com/BookStore/v1/Book'
    And header Authorization = "Bearer " + accessToken
    And request
    """
        {
          "isbn": "#(isbn)",
          "userId": "#(userId)"
        }
    """
    * method delete
    Then status 204


