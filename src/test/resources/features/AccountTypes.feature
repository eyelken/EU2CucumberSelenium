Feature: Account types
  @smoke  @regression
  Scenario: Driver user
    * the user logged in as "driver"
    * the user navigates "Activities" "Calendar Events"
    * the title contains "Calendar Events - Activities"
  @smoke  @regression
  Scenario: Sales manager user
    Given the user logged in as "sales manager"
    When the user navigates "Customers" "Accounts"
    Then the title contains "Accounts - Customers"
  @regression
  Scenario: Store manager user
    Given the user logged in as "store manager"
    When the user navigates "Customers" "Contacts"
    Then the title contains "Contacts - Customer"
  @regression
  Scenario Outline: Login with Different accounts <userType>
    Given the user logged in as "<userType>"
    When the user navigates "<tab>" "<module>"
    Then the title contains "<title>"

    Examples:
      | userType      | tab        | module          | title                                                              |
      | driver        | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System       |
      | driver        | Customers  | Accounts        | Accounts - Customers                                               |
      | driver        | Customers  | Contacts        | Contacts - Customers                                               |
      | driver        | Activities | Calendar Events | Calendar Events - Activities                                       |
      | driver        | System     | Jobs            | Jobs - System                                                      |
      | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | sales manager | System     | Jobs            | All - Jobs - System                                                |
      | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | store manager | System     | Jobs            | All - Jobs - System                                                |
      | store manager | System     | Menus           | All - Menus - System                                               |

@test @regression
  Scenario Outline: Login with different users: "<userType>"
    Given the user logged in as "<userType>"

    Examples:
      | userType      |
      | driver        |
      | admin         |
      | sales manager |
      | store manager |