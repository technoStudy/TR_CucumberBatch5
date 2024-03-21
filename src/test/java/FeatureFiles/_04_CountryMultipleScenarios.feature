Feature: Country Multi Scenario

  Background: #before senaryo
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country

  Scenario: Create a Country
    When Create a country
    Then Success message should be displayed

  Scenario: Create a Country 2
    When Create a country name as "ismUlk12" code as "ismUlk12Kod"
    Then Success message should be displayed