Feature: Common feature include scenario reused

  @initData
  Scenario: init Data from json file
    * def evn = env
    * def pathFile = pathFile
    * def Utilities = Java.type('auto.utils.external.Utilities')
    * def utilities = new Utilities()
    * def initData = utilities.getDataFromJsonFile(pathFile,evn)
    * print 'initData=>>>>>>>',initData