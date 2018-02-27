package tests.single.RegressionSuite;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

public class C724 extends TestBase {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void VerifyRightNavigationArrows() {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.closeRegistration();

        WebDriverUtils.pressKey(driver, Keys.ARROW_RIGHT);
//        eyes.checkWindow("Right key on keyboard should take user to next scene");
    }
}