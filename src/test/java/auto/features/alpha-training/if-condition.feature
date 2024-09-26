Feature: if condition

  @if-condition
  Scenario: if condition
    * def demo = 1
    * def nonIT = 2
    * print '========demo:',demo
#    * if (demo == 1 || nonIT != 2) demo = "demo23456789o678"
    * if (demo == 1 || nonIT != 2) karate.call('classpath:auto/features/alpha-training/if-condition.feature@another')
    * if (demo == 1) karate.call('classpath:auto/features/common/login/Login.feature@login')
#    * print '========demo11111:',demo

    * def demo = (demo == 'demo') ? 2 : "abc"
#
    * print '========demo2222:',demo

  @another
  Scenario: reuse
    * print "Demo IF condition"

