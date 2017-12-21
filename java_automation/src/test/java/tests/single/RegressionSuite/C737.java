package tests.single.RegressionSuite;

import automationFramework.pages.IubExperiencePage;
import automationFramework.pages.IubHomePage;
import automationFramework.pages.IubRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class C737 extends TestBase {
    private IubRegistrationPage iubRegistrationPage;
    private IubExperiencePage iubExperiencePage;
    private IubHomePage iubHomePage;

    @Test(priority = 1)
    public void ScrollableExperienceSelector() {
        iubRegistrationPage = pageObjectsHandler.getIubRegistrationPage();
        iubExperiencePage = iubRegistrationPage.closeRegistrationModal();


        Assert.assertTrue(iubExperiencePage.verifyScroll());
    }
}