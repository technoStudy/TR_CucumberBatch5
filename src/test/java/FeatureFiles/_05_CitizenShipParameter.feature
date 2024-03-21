#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)
#Ayrı sebaryoda girilen bilgiyi silme işlemini doğrulayınız

Feature: Citizenship Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to CitizenShip

  Scenario: Create a Citizenship with parameter
    When Create a CitizenShip name as "ismetcs1212" shortkod as "icskod1212"
    Then Success message should be displayed

  Scenario: Create a Citizenship with parameter
    When Create a CitizenShip name as "ismetcs1212" shortkod as "icskod1212"
    Then Already exist message should be displayed

  Scenario: Delete Citizenship
    When user delete name as "ismetcs1212"
    Then Success message should be displayed