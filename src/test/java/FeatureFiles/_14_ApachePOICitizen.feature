Feature: ApachePOI Citizen functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to CitizenShip

  Scenario: Create and Delete CitizenShip from excel
    When User create citizenship with ApchePOI
    Then User delete citizenship with ApchePOI