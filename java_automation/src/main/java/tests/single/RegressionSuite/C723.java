package tests.single.RegressionSuite;

import automationFramework.pages.*;
import automationFramework.utils.WebDriverUtils;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

public class C723 extends BaseTest {


    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;
    private StonybrookExperiencePage stonybrookExperiencePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void VerifyNavigationArrows() {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.closeRegistration();
        stonybrookHomePage.navigateFrontButton();
        stonybrookHomePage.navigateBackButton();
        eyes.checkWindow("Navigation Arrows Check");
    }
}
