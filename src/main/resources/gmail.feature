Feature: Gmail
  I want to test gmail functionality

  Scenario Outline: Open Login Page to login
    Given User opens '<loginPage>' page
    And User clicks on Login button
    When User introduces login '<keyword>'
    And User clicks on Next button
    And User write password '<password>'
    And User clicks on Next button

    Examples:
      | loginPage              | keyword               | password       |
      | https://www.google.com | t70414138@gmail.com   | Qwerty!12345   |
