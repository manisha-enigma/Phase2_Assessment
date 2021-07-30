Feature: Product features scenario

  Background: 
    Given User has opened Swaglab application
    When User enters the username "standard_user"
    And User enters the password "secret_sauce"
    And Click on Login Button

  @SingleProductAdd
  Scenario Outline: Verify that user able to add the product to Cart
    Given User should landed on home page
    And User selects product and click on the add to cart button "<product>"
    Then User should be able to see the product in cart

    Examples: 
      | product             |
      | Sauce Labs Backpack |

  @MultipleProductAdd @DataTable
  Scenario: Verify that user can add multiple products on cart
    Given User should landed on home page
    And User add multiple products to the cart
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Fleece Jacket          |
      | Test.allTheThings() T-Shirt (Red) |
    Then User should be able to see the product in cart