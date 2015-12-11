Feature: Create then delete new Tour

  @javascript
  Scenario: Verify that user can go to Virtual Tours page from homepage
    Given I go to "/"
    And I click on the log in button
    And I fill in id
    And I fill in password
    And I press "loginButton"
    And I click New Tour
    And I fill in "location[name]" with "Test"
    And I select "User" from Tour Type
    And I press "CREATE TOUR"
    Then I should see text matching "Well this is a boring stop, let's add some media to it!"
    Given I follow "QATester"
    When I click the delete button
    Then the deleted Tour should no longer be present




