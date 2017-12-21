package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.annotations.Test;
import tests.base.TestBase;

import static org.testng.Assert.assertTrue;

public class VerifyingThatTourLoads extends TestBase {
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Test(groups = { "REGRESSION"})
    public void verifyingThatTourLoads() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        //stonybrookRegistrationPage = PageFactory.initElements(driver, StonybrookRegistrationPage.class);
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        assertTrue(stonybrookHomePage.navigateForwardButtonIsDisplayed(), "Navigate forward button was not detected.");
    }
}