package tests.single.RegressionSuite;

import automationFramework.pages.DarthmouthExperiencePage;
import automationFramework.pages.DarthmouthHomePage;
import automationFramework.pages.DarthmouthRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class C6 extends TestBase {
    private DarthmouthRegistrationPage darthmouthRegistrationPage;
    private DarthmouthExperiencePage darthmouthExperiencePage;
    private DarthmouthHomePage darthmouthHomePage;

    @Test(priority = 1)
    public void CloseSelectorDrawer() {
        darthmouthRegistrationPage = pageObjectsHandler.getDarthmouthRegistrationPage();
        darthmouthExperiencePage = darthmouthRegistrationPage.closeRegistrationModal();
        darthmouthHomePage = darthmouthExperiencePage.closeExperiencePage();

        Assert.assertFalse(darthmouthHomePage.navigateToExperiences().selectAthleticExperience().verifyExperienceDrawerIsNotDisplayed());
    }
}