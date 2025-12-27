@cart
Feature: Shopping Cart Management
  As an online shopper
  I want to manage items in my shopping cart
  So that I can purchase the products I need

  Background:
    Given the user is logged in
    And the product catalog is available

  @smoke
  Scenario: Add single item to cart
    # TODO: Write the scenario
    # Given: User is on a product page
    # When: User clicks add to cart
    # Then: Item appears in cart, cart count updates
    Given the user is on a product page
    When the user clicks add to cart
    Then the item appears in cart
    And the item count updates


  Scenario: Add multiple quantities of an item
    # TODO: Write the scenario
    # Consider quantity selector interaction
    Given the user is on a product page
    When the user sets the quantity to 3
    And the user clicks "Add to Cart"
    Then the item appears in the cart
    And the cart shows a quantity of 3 for the item

  Scenario: View cart contents
    # TODO: Write the scenario
    # Include verification of item details shown
    Given the user has at least one item in the cart
    When the user navigates to the cart page
    Then the cart displays the item
    And the cart shows the item name
    And the cart shows the item price
    And the cart shows the item quantity

  Scenario: Update item quantity in cart
    # TODO: Write the scenario
    # Include before/after quantity and price verification
    Given the cart contains an item with a quantity of 3 and a price of $30
    When the user updates the item quantity to 5
    Then the cart shows the item quantity as 5
    And the total price is updated to $50

  Scenario: Remove item from cart
    # TODO: Write the scenario
    # Verify item no longer appears and price updates
    Given the cart contains an item named "Paper Towel"
    When the user removes the item named "Paper Towel"
    Then the cart no longer displays the item named "Paper Towel"
    And the total cart price no longer includes the price of "Paper Towel"

  Scenario: Empty cart displays message
    # TODO: Write the scenario
    # Verify appropriate message when cart is empty
    Given the cart is empty
    When the user navigates to the cart page
    Then the cart displays the message "Your cart is empty"


  Scenario: Cart total calculates correctly
    Given the user has the following items in cart:
      | Product     | Price  | Quantity |
      | Widget A    | 10.00  | 2        |
      | Widget B    | 25.00  | 1        |
    When the user views the cart
    Then the cart subtotal should be "$45.00"