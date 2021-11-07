@Firefox
@UI
Feature: The feature contains scenarios related to login functionality

  Scenario: User is logged in successfully
    Given the user is loading the application
    When login page is displayed
    And the user is logged in with username standard_user and password secret_sauce
    Then product lister page is displayed

  Scenario: User is trying to login with wrong credentials
    Given the user is loading the application
    When login page is displayed
    Then the user is logged in with following wrong credentials
      | username | password | errorMessage                                                              |
      | user1    | pass1    | Epic sadface: Username and password do not match any user in this service |
      | user2    | pass2    | Epic sadface: Username and password do not match any user in this service |

  Scenario Outline: User is logged in successfully
    Given the user is loading the application
    When login page is displayed
    And the user is logged in with username <username> and password <password>
    Then product lister page is displayed

    Examples:
      | username                | password      |
      | standard_user           | secret_sauce  |
      | problem_user            | secret_sauce  |
      | performance_glitch_user | secret_sauce  |
