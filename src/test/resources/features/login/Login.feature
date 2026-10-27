Feature: Login functional

  As a user, I want to login app, so that I can view my profile

  Scenario: Verify login successfully with valid credentials
    Given user is on the login page
    When user login with valid credentials "bod@example.com" and "123456"
    Then home page displays
