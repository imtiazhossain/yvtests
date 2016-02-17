Feature: Upload a video

  Background:
    Given I go to "/"
    And I click on the log in button
    And I fill in id
    And I fill in password
    And I press "loginButton"
    And I edit a tour

  @javascript
  Scenario: Verify that I can upload videos
    And I upload a Video
    Then I assert that the video exists
    Then I delete the video
