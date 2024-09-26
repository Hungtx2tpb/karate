Feature: Database Common

  Scenario: Database Common
    * def env = env
    * def DbUtils = Java.type('auto.utils.external.DbUtils')
    * def dbAutoTest = new DbUtils('dbAutoTest',env)
