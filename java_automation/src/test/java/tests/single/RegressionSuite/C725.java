package tests.single.RegressionSuite;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class C725 extends TestBase {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Test(priority = 1)
    public void VerifyLeftNavigationArrows() {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.closeRegistration();

        WebDriverUtils.pressKey(driver, Keys.LEFT);
        eyes.checkWindow("Left key should take user to previous scene");
    }
}