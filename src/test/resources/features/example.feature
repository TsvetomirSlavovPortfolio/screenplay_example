Feature: Searching by keyword

  In order to find items that I would like to purchase
  As a potential buyer
  I want to be able to search for items containing certain words

  Scenario: Should list items related to a specified keyword
    Given Pietje is logged in
    When Pietje retrieves the inventory of 'tulips'
