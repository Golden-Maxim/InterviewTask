Feature: Switch languages

  @Smoke
  Scenario: As I am a user I switch language
    Given I am on the Main Page
    When I switch language to Svenska
    Then I check that language is Svenska

  @Smoke
  Scenario: As I am a user I switch language
    Given I am on the Main Page
    When I switch language to Suomi
    Then I check that language is Suomi

