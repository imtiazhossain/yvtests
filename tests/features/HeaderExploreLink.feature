Feature: youvisit.com home
	In order to find Youvisit.com home
	As a user
	I need to be able to navigate to youvisit.com

  	@javascript
	Scenario: Navigating to youvisit.com
		Given I go to "/"
        When I click on the explore link
		Then I should be on "/virtual-reality-and-virtual-tours"