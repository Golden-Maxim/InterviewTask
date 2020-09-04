Feature: Switch between pages

  @Smoke
  Scenario Outline: As I am a user I want to switch between pages
    Given I am on the Main Page
    When I click to <var>
    Then I check that I am on the <var>
    Examples:
      | var                  |
      | Customer Service     |
      | Regional Settings    |
      | Create Account       |
      | Login                |
      | About Us             |
      | Delivery Information |
      | Privacy Policy       |
      | Terms & Conditions   |
      | Rubber Ducks         |
