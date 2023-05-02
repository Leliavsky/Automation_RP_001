Feature: Filter
  I want to test all main Filter functionality

  Scenario Outline: Open Login Page to login
    Given User opens '<loginPage>' page
    When User introduces login '<keyword>'
    And User write password '<password>'
    And User clicks on Login button

    Examples:
      | loginPage             | keyword   | password |
      | http://localhost:8080 | default   | 1q2w3e   |
