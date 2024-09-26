Feature: demo jsonPath

  @addBook
  Scenario: demo jsonPath
    Given url baseUrl + '/BookStore/v1/Books'
    * method get
    * status 200
    * print response
    #$.books[?(@.isbn)]
    * def isbn = response.books[0].isbn
    * print "isbn theo index: ", isbn

    * def arrayIsbn = karate.jsonPath(response,"$.books[*].isbn")
#
    * print "isbn theo điều kiện: ", arrayIsbn.length
    * print "isbn theo điều kiện: ", arrayIsbn

    * def nameBook = karate.jsonPath(response,"$.books[?(@.isbn==9781449325862)].title")
    * print "nameBook theo điều kiện: ", nameBook

    * karate.set('response','$.books[?(@.isbn==9781449325862)].title','value is Changed')
    * print "response sau khi thay đổi giá trị: ", response

#    * print karate.jsonPath(response,"$.books[*].isbn")

#    * match karate.jsonPath(response,"$.books[*].isbn") contains "9781449331818"
#    * def idBook = response.books[0].isbn
#    * match idBook == '9781449325862'

  Scenario: using condition in jsonPath to set or remove field
    * def jsonBody =
  """
  {
    "company": "Alphaway",
    "staff": [
        {
            "id": 11,
            "name": "Bob"
        },
        {
            "id": 12,
            "name": "Avb"
        },
        {
            "id": 14,
            "name": "Tung"
        },
        {
            "id": 19,
            "name": "Huan"
        }
    ]
}
  """

    * karate.set('jsonBody','$.staff[?(@.id==12)].name','value is Changed')
    * print 'jsonBody =>>>>>>>',jsonBody
    * karate.remove('jsonBody','$.staff[?(@.id==12)].name')
    * print 'jsonBody =>>>>>>>',jsonBody


