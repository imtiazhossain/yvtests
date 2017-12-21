package tests.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import tests.base.TestBase;

public class HomepageSteps extends TestBase{

    @Given("^that user navigates to YouVisit$")
    public void navigateToYouVisit() {
        driver.get("https://www.youvisit.com/tour/stonybrook");
    }


    @Then("^Page loads$")
    public void validateLogoOnPage() {

    }
}
