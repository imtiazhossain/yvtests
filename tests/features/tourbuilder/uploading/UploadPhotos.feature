Feature: Upload a photo

  @javascript
  Scenario: Verify that I can upload photos
    Given I go to "/"
    And I click on the log in button
    And I fill in id
    And I fill in password
    And I press "loginButton"
    And I edit a tour
    And I upload a Photo
    Then I assert that the photo exists
    Then I delete the photo