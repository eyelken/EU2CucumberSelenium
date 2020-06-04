@Navigate
Feature: Navigate Menu
  Scenario: Navigate to Fleet, Vehicles
    Given the user is on the login page
    When the user enter sales manager information
    Then the user navigates "Fleet" "Vehicles"
    Then the title contains "Vehicles"

  Scenario: Navigate to Marketing, Campaigns
      Given the user is on the login page
      When the user enter sales manager information
      Then the user navigates "Marketing" "Campaigns"
      Then the title contains "Campaigns"

    Scenario: Navigate to Activities, Calendar Events
      Given the user is on the login page
      When the user enter sales manager information
      Then the user navigates "Activities" "Calendar Events"
      Then the title contains "Calendar Events"