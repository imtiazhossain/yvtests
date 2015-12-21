Feature: Upload a 360 Video

  @javascript
  Scenario: Verify that I can upload 360s
    Given I go to "/"
    And I click on the log in button
    And I click sign in
    And I fill in id
    And I fill in password
    And I press "loginButton"
    And I edit a tour
    And I upload a 360 Video
    Then I assert that the 360 exists
    Then I delete the 360