@Api
Feature: The feature contains API

  Scenario: User is filtering products and verifies the price of a particular product
    Given request has header "Cookie: __cfduid=d53cb4180ff8c995719f99879bd7d89cd1614538038"
    And country is "us"
    And zip code is "90210"
    When the client calls the REST API endpoint
    Then the status code is 200
