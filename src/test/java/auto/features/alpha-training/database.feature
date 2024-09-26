Feature: Login

  @database
  Scenario: database test
    * def env = env
    * def DbUtils = Java.type('auto.utils.external.DbUtils')
    * def dbDemo = new DbUtils('demo',env)
    * def queryMulti = "SELECT * FROM staffs"
    * def resultMulti = dbDemo.readRows(queryMulti)
    * print 'result===>>>', resultMulti
    * print 'name====>>>>', resultMulti[0].name

    * def querySingle = "SELECT * FROM staffs LIMIT 1"
    * def resultSingle = dbDemo.readRow(querySingle)
    * print 'result===>>>', resultSingle
    * print 'name====>>>>', resultSingle.name