
Feature: Product Scenarios

  Scenario Outline: Validate product info on Products page
    Given I'm logged in
    Then the product is listed with title "<title>" and price "<price>"
    Examples:
      | title                   | price  |
      | Sauce Labs Bolt T-Shirt | $15.99 |

  Scenario Outline: Validate product info on Products page
    Given I'm logged in
    When I click on the product title "<title>"
    Then I should be on the products details page with title "<title>",price "<price>" and description "<description>"
    Examples:
      | title               | price  | description                                                                                                                            |
      | Sauce Labs Backpack | $29.99 | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection. |