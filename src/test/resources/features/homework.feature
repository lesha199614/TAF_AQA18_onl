Feature: SauceDemo

  Scenario: E2E Test
    Given open SauceDemo
    * login successful
    When open first Item
    * add item to Cart
    * open Cart