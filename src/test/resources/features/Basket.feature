Feature: Basket

  @Smoke
  Scenario: As I am a user I want to move the product in the basket
    Given I am on the Main Page
    When I want to buy a Blue Duck
    Then I check that Basket contains Blue Duck
    Then I delete a product and check that product is not in the Basket



  @Smoke
  Scenario: As I am a user I want to move the product in the basket
    Given I am on the Main Page
    When I want to buy a Purple Duck
    Then I check that Basket contains Purple Duck
    Then I delete a product and check that product is not in the Basket



  @Smoke
  Scenario: As I am a user I want to move the product in the basket
    Given I am on the Main Page
    When I want to buy a Green Duck
    Then I check that Basket contains Green Duck
    Then I delete a product and check that product is not in the Basket



  @Smoke
  Scenario: As I am a user I want to move the product in the basket
    Given I am on the Main Page
    When I want to buy a Red Duck
    Then I check that Basket contains Red Duck
    Then I delete a product and check that product is not in the Basket


  @Smoke
  Scenario:As I am a user I want to move the product in the basket
    Given I am on the Main Page
    When I want to buy a Pennyduck
    Then I check that Basket contains Pennyduck
    Then I delete a product and check that product is not in the Basket


  @Smoke
  Scenario: As I am a user I want to move the product in the basket
    Given I am on the Main Page
    When I want to buy a Yellow Duck
    Then I check that Basket contains Yellow Duck
    Then I delete a product and check that product is not in the Basket

