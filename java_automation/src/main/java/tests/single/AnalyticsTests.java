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

            driver.navigate().refresh();

            //Parse JSON from URL
            parseJSON(analyticsURL("&stops=4&actions=0&modules=2"));
    }

    @Test(priority = 4)
    public void verifyingArrowButtonAnalytics() throws Exception {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        assertTrue(stonybrookHomePage.navigateForwardButtonIsDisplayed(), "Navigate forward button was not detected.");
        stonybrookHomePage.clickNavigateForward();
        stonybrookHomePage.clickNavigateRight();
        stonybrookHomePage.clickNavigateForwardLeft();
        stonybrookHomePage.clickNavigateForward();
        stonybrookHomePage.clickNavigateForward();

        driver.navigate().refresh();

        //Parse JSON from URL
        parseJSON(analyticsURL("&stops=2&actions=0&modules=2"));
    }
}
