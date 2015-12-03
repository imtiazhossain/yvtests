Feature: Create then delete new Tour

  @javascript
  Scenario: Verify that user can go to Virtual Tours page from homepage
    Given I go to "/"
    When I follow "Create"
    And I follow "Get Started"
    And I follow "Get Started"
    And I follow "Log In"
#    And I log in
#    Then I should see "test"

#  Scenario: Verify that user can create a new Tour
#
#    Given that user is on the Tour builder page
#    When the user click on the 'New Tour' tile
#    And enters info in 'Create a new tour' pop out
#    Then the 'New Tour' page should show
#
#  Scenario: Verify that user can delete a create Tour
#
#    Given that user created a tour
#    When the user clicks the delete button
#    Then deleted Tour should no longer be present