Feature: Test5_6
  In order to change an items previously selected.
  As a customer
  I want to be able to remove an item from the cart.

  Scenario: Test5 remove phone from cart

    Given I have an item in my cart that i want to remove
    When I remove a samsung mobile
    Then I should have an empty cart without that mobile