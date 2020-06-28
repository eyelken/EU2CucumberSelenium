@login
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  @driver @smoke @VYT-123 @wip
  Scenario: Login as a driver
    When the user enter the driver information
    Then the user should be able to login

  @sales_manager @VYT-123
  Scenario: Login as a sales manager
    When the user enter sales manager information
    Then the user should be able to login

  @store_manager @smoke @wip
  Scenario: Login as a store manager
    When the user enter store manager information
    Then the user should be able to login
  @admin
  Scenario: login as admin
    Given the user is on the login page
    When the user enter admin information
    Then the user should be able to login