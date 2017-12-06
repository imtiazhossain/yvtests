package tests.single.RegressionSuite;

import automationFramework.pages.DarthmouthExperiencePage;
import automationFramework.pages.DarthmouthHomePage;
import automationFramework.pages.DarthmouthRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

public class C6 extends BaseTest {
    private DarthmouthRegistrationPage darthmouthRegistrationPage;
    private DarthmouthExperiencePage darthmouthExperiencePage;
    private DarthmouthHomePage darthmouthHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void CloseSelectorDrawer() {
        darthmouthRegistrationPage = pageObjectsHandler.getDarthmouthRegistrationPage();
        darthmouthExperiencePage = darthmouthRegistrationPage.closeRegistrattionModal();
        darthmouthHomePage = darthmouthExperiencePage.closeExperiencePage();

        Assert.assertFalse(darthmouthHomePage.navigateToExperiences().selectAthleticExperience().verifyExperienceDrawerIsNotDisplayed());
    }
}