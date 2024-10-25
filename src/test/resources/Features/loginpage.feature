Feature: Login Functionality for Opencart E-commerce Website

  As a user of the opencart website
  I want to be able to log in with my account
  So that I can access my account-related features and manage my orders

  Background:
    Given I am on the Opencart login page

  Scenario Outline: Successful login with valid credentials
    Given I have entered a valid "<valid_username>" and "<valid_password>"
    When I click on the login button
    Then I should be logged in successfully

    Examples:
      | valid_username         | valid_password |
      | qatestertest@gmail.com |Test@123        |

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                                        |
      | invalid@gmail.com | invalidpassword | Warning:No match for E-mail address and/or password. |
    |abbccc             |validpassword    | Warning:No match for E-mail address and/or password. |

  Scenario: Navigating to the forgotten password page
    When I click on the "Forgotten Password" link
    Then I should be redirected to the password reset page

