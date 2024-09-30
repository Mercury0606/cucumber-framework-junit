Feature: Search and add to cart and  order the Products as E2E

  @Placeholder
  Scenario Outline: Search Experience for product search in both home and offers page
    Given User is on GreenCart Landing Page
    When User searched with shortname <Name> and extracted actual name of product
    And Add 3 items of the selected product to cart
    Then User proceeds to Checkout and validate the <Name> items in checkout page
    And Verify user has ability to enter promo code and place the order


    Examples:
      | Name |
      | Broco--- |

