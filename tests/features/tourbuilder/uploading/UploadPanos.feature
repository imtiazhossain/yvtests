Feature: Upload a panoroma

  @javascript
  Scenario: Verify that I can upload panos
    Given I go to "/"
    And I click on the log in button
    And I fill in id
    And I fill in password
    And I press "loginButton"
    And I edit a tour
    And I upload a Panos
    Then I assert that the panos exists
    Then I delete the panos