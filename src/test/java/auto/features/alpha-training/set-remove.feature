Feature: Set and Remove keyword


  @demoSetOrRemove
  Scenario: Login get token set value
    #api1

    def demo1 = "demo"

    #api2

    #api2
    Given url 'https://bookstore.toolsqa.com/Account/v1/GenerateToken'

    * def jsonBody = read('classpath:data/common/login.json')
    * print "trước khi set giá trị=>>>>",jsonBody

    * set jsonBody.userName = "demo"
    * set jsonBody.password = "Demo@2024"
    * print "sau khi set giá trị=>>>>",jsonBody
    And request jsonBody
    * method POST
    * status 200
    * print response
    * def accessToken = response.token

#    * remove jsonBody.password
#
#    * print "thông tin file sau khi remove giá trị=>>>>",jsonBody


  Scenario: exercise 1 set value
    * def jsonBody =
    """
{
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "numberPhone": "0123-4567-8888"
        }
    ]
}
    """
    * print 'jsonBody trước khi set =>>>>>>>',jsonBody
    * set jsonBody.age = 32
    * set jsonBody.address.city = "Hà Nội"
    * set jsonBody.phoneNumbers[0].numberPhone = "0359302393"
    * print 'jsonBody sau khi set =>>>>>>>',jsonBody

  Scenario: exercise remove field
    * def jsonBody =
    """
{
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "numberPhone": "0123-4567-8888"
        }
    ]
}
    """
    * remove jsonBody.age
    * print 'jsonBody =>>>>>>>',jsonBody

  Scenario: exercise 3 using condition in jsonPath
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
    # c1
    #* def body = get[0] jsonBody.staff[?(@.id==12)]
    # c2
#    * json body = karate.jsonPath(jsonBody,"$.staff[?(@.id==12)]")[0]
#    * print 'jsonBody =>>>>>>>',body
#    # c1
#    * set body.name = 'value is changed'
    # c2
#    * karate.set('body','$.name','value is Changed')
#    # c3
    * karate.set('jsonBody','$.staff[?(@.id==12)].name','value is Changed')
    * print 'jsonBody =>>>>>>>',jsonBody
    * karate.remove('jsonBody','$.staff[?(@.id==12)].name')

    #c4
    * set jsonBody.staff[1].name = 'Tran linh'

    * print 'jsonBody =>>>>>>>',jsonBody







