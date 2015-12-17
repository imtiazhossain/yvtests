Feature: Contact Us Form

  @javascript
  Scenario: User clicks send without filling out form
    Given I go to "/contact"
    When I fill in fullname
    And I fill in email
    And I fill in phone
    And I fill in message
    And I click the Send button
