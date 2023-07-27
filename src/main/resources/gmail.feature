Feature: Gmail
  I want to test gmail functionality

  Scenario Outline: Open Login Page to login
    Given User opens '<loginPage>' page
    And User clicks on Login button
    When User introduces login '<keyword>'
    And User clicks on Next button
    And User write password '<password>'
    And User clicks on Next button
    And User clicks on Gmail button
    Then Verify success login
    And clicks on Write button
    And Create a new mail
    And click on close button
    And click on draft section
    Then Verify draft mail present
    And click on sent the email and verify empty draft
    And click on sent field to verify that email is sent
    Then Log off

    Examples:
      | loginPage              | keyword               | password       |
      | https://www.google.com | t70414138@gmail.com   | Qwerty!12345   |
