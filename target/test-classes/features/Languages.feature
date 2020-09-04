Feature: Switch languages

  @123
  Scenario Outline: As I am a user I switch language
    Given I am on the Main Page
    When I switch language to <var>
    Then I check that language is <var>
    Examples:
      | var     |
      | Svenska |
      | Suomi   |



