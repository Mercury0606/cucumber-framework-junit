Feature: Search and Place the order for Products

  @OffersPage
  Scenario Outline: Search Experience for product search in both home and offers page
    Given User is on GreenCart Landing Page
    When User searched with shortname <Name> and extracted actual name of product
    Then User searched with same <Name> in offers page
    And Validate product name in offers page matches with Landing page
    Examples:
      | Name |
      | Tom  |
      | Beet |
#      | Cauli |
#      | Carr |
#      | Bean |
#      | Brinj |
#      | Capsicu |
#      | Mushro |
#      | Potat |
#      | Tom  |
#      | Beet |
#      | Cauli |
#      | Carr |
#      | Bean |
#      | Brinj |
#      | Capsicu |
#      | Mushro |
#      | Potat |
