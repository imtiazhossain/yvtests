package tests.single.RegressionSuite;

import automationFramework.pages.IubExperiencePage;
import automationFramework.pages.IubHomePage;
import automationFramework.pages.IubRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

public class C737 extends TestBase {
    private IubRegistrationPage iubRegistrationPage;
    private IubExperiencePage iubExperiencePage;
    private IubHomePage iubHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void ScrollableExperienceSelector() {
        iubRegistrationPage = pageObjectsHandler.getIubRegistrationPage();
        iubExperiencePage = iubRegistrationPage.closeRegistrationModal();


        Assert.assertTrue(iubExperiencePage.verifyScroll());
    }
}