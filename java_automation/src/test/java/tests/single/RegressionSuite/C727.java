package tests.single.RegressionSuite;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class C727 extends TestBase {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Test(priority = 1)
    public void VerifyDownNavigationArrows() {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.closeRegistration();

        WebDriverUtils.pressKey(driver, Keys.ARROW_DOWN);
        eyes.checkWindow("Down key should take user to previous stop");
    }
}