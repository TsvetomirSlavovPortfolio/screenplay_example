Feature: Getting inventory details for a product

  In order to make sure a product is available,
  as customer,
  I want to get inventory information for a product

  Scenario: Should get
    Given Pietje is logged in
    When he retrieves the inventory for 'tulips'
    Then the inventory is '2000'
