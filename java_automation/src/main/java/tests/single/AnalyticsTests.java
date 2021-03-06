package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.annotations.Test;
import tests.base.TestBase;

import static org.testng.Assert.assertTrue;

public class AnalyticsTests extends TestBase {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Test(priority = 3)
    public void verifyingNextButtonAnalytics() throws Exception {
            stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
            stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
            assertTrue(stonybrookHomePage.navigateForwardButtonIsDisplayed(), "Navigate forward button was not detected.");
            stonybrookHomePage.clickNextButton();
            stonybrookHomePage.clickNextButton();
            stonybrookHomePage.clickNextButton();

            assertAnalytics("&stops=4&actions=0&modules=1");
    }

    @Test(priority = 4)
    public void verifyingArrowButtonAnalytics() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        assertTrue(stonybrookHomePage.navigateForwardButtonIsDisplayed(), "Navigate forward button was not detected.");
        stonybrookHomePage.clickNavigateForward();
        stonybrookHomePage.clickNavigateRight();
        stonybrookHomePage.clickNavigateForwardLeft();
        stonybrookHomePage.clickNavigateForward();
        stonybrookHomePage.clickNavigateForward();

        assertAnalytics("&stops=2&actions=0&modules=1");
    }
}
