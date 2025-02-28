Feature: Login Functionality

  @Sanity
  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters username "standard_user" and password "secret_sauce"
    And User clicks the login button
    Then User should be redirected to the homepage

  Scenario: Unsuccessful login with invalid credentials
    Given User is on the login page
    When User enters username "invalid_user" and password "wrong_password"
    And User clicks the login button
    Then User should see an error message "Epic sadface: Username and password do not match any user in this service"
