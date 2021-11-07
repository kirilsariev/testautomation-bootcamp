@Firefox
@UI
Feature: The feature contains scenarios related to product orders and operations

  Background: User is logged in
    Given the user is loading the application
    And the user is logged in with username standard_user and password secret_sauce

  Scenario: User is filtering products and verifies the price of a particular product
    And product lister page is displayed
    Then the price for product Sauce Labs Bolt T-Shirt is $15.99
