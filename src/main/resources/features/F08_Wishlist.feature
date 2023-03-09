@smoke
Feature: User Click on WishList
  Scenario: User Click on whishlist
    When user select on a product  whislist
    Then a success message appear
    Scenario: User get the Quantity from whislist menu
      Given  user select on a product  whislist
      And SuccessMsg dissappear
      When user Click on whislistBtn upright
      Then user get quantity of products greater than zero