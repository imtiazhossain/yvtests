Feature: Upload a Map file

  @javascript
  Scenario: Verify that I can upload a Map
    Given I go to "/"
    And I click on the log in button
    And I click sign in
    And I fill in id
    And I fill in password
    And I press "loginButton"
    And I edit a tour
#    And I upload an Map file
#    Then I assert that the map exists
#    Then I delete the map