# Login fonksiyon kontrolü
# Önce Siteye git  (driver.get)
# Sonra Login bilgilerini gir (username password sendkeys)
# Sonra giriş yaptığını kontrol (verify)

Feature: Login functionality

  @SmokeTest @Regression
  Scenario: Login with valid username and password

    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully