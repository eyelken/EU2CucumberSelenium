Feature: Contacts page


  Scenario: Default page number
    Given the user is on the login page
    And the user enter the driver information
    When the user navigates "Customers" "Contacts"
    Then default page number should be 1
