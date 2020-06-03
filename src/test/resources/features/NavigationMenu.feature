@SalesLogin
Feature: Sales manager should be able to Navigate Menu
  Scenario: Navigate to Fleet--Vehicles
    Given the user is on the login page
    And the user enter sales manager information
    When the user navigates to Fleet--Vehicles
    Then the title should be Vehicles

  Scenario: Navigate to Marketing--Campaigns
    Given the user is on the login page
    And the user enter sales manager information
    When the user navigates to Marketing--Campaigns
    Then the title should be Campaigns

  Scenario: Navigate to Activities--Calendar Events
    Given the user is on the login page
    And the user enter sales manager information
    When the user navigates to Activities--Calendar Events
    Then the title should be Calendar Events