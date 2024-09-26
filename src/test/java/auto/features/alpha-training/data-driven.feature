Feature: data driven

  @data-driven
  Scenario Outline: data driven dùng data ở examples
    #api1
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

    # add books  #api2
    Given url 'https://bookstore.toolsqa.com/BookStore/v1/Books'
    And header Authorization = "Bearer " + accessToken
    And request
    """
        {
            "userId": "<userId>",
            "collectionOfIsbns": [
                {
                    "isbn": "<isbn>"
                }
            ]
        }
    """
    * method post
    Then status 201
    # delete book
    Given url 'https://bookstore.toolsqa.com/BookStore/v1/Book'
    And header Authorization = "Bearer " + accessToken
    And request
    """
        {
          "isbn": "<isbn>",
          "userId": "<userId>"
        }
    """
    * method delete
    Then status 204
    Examples:
      | isbn          | userId                               |
      | 9781449337711 | 4ad35d66-2847-4d87-8de7-43449653b67e |
      | 9781449331818 | 4ad35d66-2847-4d87-8de7-43449653b67e |

  @data-driven
  Scenario Outline: data driven dùng data đọc từ csv file
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

    # add books
    Given url 'https://bookstore.toolsqa.com/BookStore/v1/Books'
    And header Authorization = "Bearer " + accessToken
    And request
    """
        {
            "userId": "<userId>",
            "collectionOfIsbns": [
                {
                    "isbn": "<isbn>"
                }
            ]
        }
    """
    * method post
    Then status 201
    # delete book
    Given url 'https://bookstore.toolsqa.com/BookStore/v1/Book'
    And header Authorization = "Bearer " + accessToken
    And request
    """
        {
          "isbn": "<isbn>",
          "userId": "<userId>"
        }
    """
    * method delete
    Then status 204
    Examples:
      | read('classpath:src/test/resources/data/data-test/data-driven.csv') |

  @data-driven-features
  Scenario: data driven features
    * table books
      | isbn            | userId                                 |
      | '9781449337711' | '4ad35d66-2847-4d87-8de7-43449653b67e' |
      | '9781449331818' | '4ad35d66-2847-4d87-8de7-43449653b67e' |
    * call read('classpath:auto/features/alpha-training/addBook.feature') books
