Feature: Country Functionality

  @SmokeTest
  Scenario: Create a country

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country
    When Create a country
    Then Success message should be displayed