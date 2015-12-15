Feature: Add stop and delete stop

  @javascript
  Scenario: Verify that I can add and delete stops
    Given I go to "/"
    And I click on the log in button
    And I fill in id
    And I fill in password
    And I press "loginButton"
    And I edit a tour
    And I click Add Stop
    Then I delete the Stop






