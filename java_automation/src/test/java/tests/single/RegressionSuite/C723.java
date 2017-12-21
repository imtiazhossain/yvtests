package tests.single.RegressionSuite;

import automationFramework.pages.StonybrookExperiencePage;
import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class C723 extends TestBase {


    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;
    private StonybrookExperiencePage stonybrookExperiencePage;

    @Test(priority = 1)
    public void VerifyNavigationArrows() {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.closeRegistration();
        stonybrookHomePage.navigateFrontButton();
        stonybrookHomePage.navigateBackButton();
        eyes.checkWindow("Navigation Arrows Check");
    }
}
