Feature: Login as different users

@smoke
  Scenario: login as a driver user
    Given the user is on the login page
    When the user logs in using "user1" and "UserUser123"
    Then the user should be able to login
    And the title contains "Dashboard"

  @wip  #Homework
  Scenario: login as a userType
    Given the user logged in as "store manager"
    Then the user should be able to login
    And the title contains "Dashboard"
    #you will have only one step definitions for this.
    #driver,sales manager,store manager
