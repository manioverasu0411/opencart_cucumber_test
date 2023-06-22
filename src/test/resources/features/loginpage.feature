Feature: Login Functionality for OpenCart E-commerce Website

  As a user of the opencart website
  I want to be able to log in with My account
  so that i can access my account related features and manage my orders

  Background:
    Given I am on OpenCart Login Page

    Scenario: Successful login with Valid Credentials
      Given I have entered a valid username and password
      When i click on the login button
      Then i should logged in successfully

    Scenario Outline: Unsuccessful login with invalid or Empty credentials
      Given i have entered invalid "<username>" and "<password>"
      When i click on the login button
      Then i should see an error message indicating "<error_message>"

      Examples:
        | username          | password        | error_message                                         |
        | invalid@gmail.com | invalidPassword | Warning: No match for E-Mail Address and/or Password. |
        | abccc             | validPassword   | Warning: No match for E-Mail Address and/or Password. |
        | valid@gmail.com   | abccc           | Warning: No match for E-Mail Address and/or Password. |

      Scenario: Navigating to the forgotten password page
        When I click on the Forgotten Password link
        Then I should be redirected to the password reset page
