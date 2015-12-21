Feature: Upload an Audio file

  @javascript
  Scenario: Verify that I can upload an Audio
    Given I go to "/"
    And I click on the log in button
    And I click sign in
    And I fill in id
    And I fill in password
    And I press "loginButton"
    And I edit a tour
    And I upload an Audio file
    Then I assert that the audio exists
    Then I delete the audio
