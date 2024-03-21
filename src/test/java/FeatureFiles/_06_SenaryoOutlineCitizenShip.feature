Feature: Citizenship Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to CitizenShip

  Scenario Outline: Create a Citizenship with parameter
    When Create a CitizenShip name as "<name>" shortkod as "<shortName>"
    Then Success message should be displayed

    When Create a CitizenShip name as "<name>" shortkod as "<shortName>"
    Then Already exist message should be displayed

    When user delete name as "<name>"
    Then Success message should be displayed

    Examples:
      | name   | shortName   |
      | ismCS1d | ismCS1short |
      | ismCS2d | ismCS2short |
      | ismCS3d | ismCS3short |
      | ismCS4d | ismCS4short |
      | ismCS5d | ismCS5short |
