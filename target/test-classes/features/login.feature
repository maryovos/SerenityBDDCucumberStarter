Feature: User Login
  As a user,
  I want to be able to log in to my account using a username and password,
  So that I can access orange HRM Live website

  Background:
    Given user is on the login page

  @Login @Valid
  Scenario: Login with valid username & password
    When user enters a valid username
    And user enters a valid password
    And clicks the Login button
    Then user should be redirected to the "dashboard" page

  @Login @InValid
  Scenario: Login with invalid username & password
    When user enters a invalid username
    And user enters a invalid password
    And clicks the Login button
    Then user should see an error message "Invalid credentials"
