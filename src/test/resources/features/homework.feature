Feature: SauceDemo

  Scenario: E2E Test
    Given open SauceDemo
    * login successful
    When open first Item
    * add item to Cart
    * open Cart
    * complete order with first name "Alex", last name "Vayteh", zip code "01-218"
    Then Text "THANK YOU FOR YOUR ORDER" is shown

  Scenario: Booking
    Given open Booking
    When search for "NYX Herzliya" destination
    Then "NYX Herzliya" hotel result exist