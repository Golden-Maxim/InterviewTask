Feature: Negative and positive test for log in form

  @Smoke
  Scenario: As I am a user I want to log in with positive credentials and log out
    Given I am on the Main Page
    When I enter email "3360333@gmail.com" and password "111111"
    Then I check the message You are now logged in as Andrii Melchenko.
    Then I log out and check the message "You are now logged out."


  @Smoke
  Scenario: Log in with negative email and password
    Given I am on the Main Page
    When I enter email "test@gmail.com" and password "password"
    Then I check the message Wrong password or the account is disabled, or does not exist


  @Smoke
  Scenario: Log in without password
    Given I am on the Main Page
    When I log in to the Site without Password
    Then I check the message You must provide both email address and password.



