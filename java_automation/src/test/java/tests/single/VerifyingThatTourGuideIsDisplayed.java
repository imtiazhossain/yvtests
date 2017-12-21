package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.annotations.Test;
import tests.base.TestBase;

import static org.testng.Assert.assertTrue;

public class VerifyingThatTourGuideIsDisplayed extends TestBase {
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Test(groups = { "SMOKE"})
    public void verifyingThatTourLoads() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        assertTrue(stonybrookHomePage.avatarIsDisplayed(), "Avatar was not displayed on startup.");
    }
}
