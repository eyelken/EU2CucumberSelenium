Feature: Account types

  Scenario: Driver user
    Given the user logged in as "driver"
    When the user navigates "Activities" "Calendar Events"
    Then the title contains "Calendar Events - Activities"

    Scenario: Sales manager user
      Given the user logged in as "sales manager"
      When the user navigates "Customers" "Accounts"
      Then the title contains "Accounts - Customers"
  @wip
    Scenario: Store manager user
      Given the user logged in as "store manager"
      When the user navigates "Customers" "Contacts"
      Then the title contains "Contacts - Customers"
