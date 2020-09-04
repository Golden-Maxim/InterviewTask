Feature: Basket

  @Smoke
  Scenario Outline: As I am a user I want to move the product in the basket
    Given I am on the Main Page
    When I want to buy a <var>
    Then I check that Basket contains <var>
    Then I delete a product and check that product is not in the Basket
    Examples:
      | var         |
      | Blue Duck   |
      | Purple Duck |
      | Green Duck  |
      | Red Duck    |
      | Pennyduck   |
      | Yellow Duck |


