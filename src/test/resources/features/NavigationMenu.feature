@SalesNavigate
Feature: Navigate Menu
  Scenario: Navigate to Fleet, Vehicles
    Given the user is on the login page
    When the user enter sales manager information
    Then the user navigate to Fleet, Vehicles
    Then the expected title should be Vehicles

  Scenario: Navigate to Marketing, Campaigns
      Given the user is on the login page
      When the user enter sales manager information
      Then the user navigate to Marketing, Campaigns
      Then the expected title should be Campaigns

    Scenario: Navigate to Activities, Calendar Events
      Given the user is on the login page
      When the user enter sales manager information
      Then the user navigate to Activities, Calendar Events
      Then the expected title should be Calendar Events