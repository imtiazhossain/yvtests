package tests.single.RegressionSuite;

import automationFramework.pages.DarthmouthExperiencePage;
import automationFramework.pages.DarthmouthHomePage;
import automationFramework.pages.DarthmouthRegistrationPage;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class C402 extends TestBase {
    private DarthmouthRegistrationPage darthmouthRegistrationPage;
    private DarthmouthExperiencePage darthmouthExperiencePage;
    private DarthmouthHomePage darthmouthHomePage;

    @Test(priority = 1)
    public void VerifyClickExpNameOpenMenu() {
        darthmouthRegistrationPage = pageObjectsHandler.getDarthmouthRegistrationPage();
        darthmouthExperiencePage = darthmouthRegistrationPage.closeRegistrationModal();
        darthmouthHomePage = darthmouthExperiencePage.closeExperiencePage();
        darthmouthHomePage.clickDarrhMouthCollegueExperienceLbl();
        darthmouthExperiencePage.selectExpDartmouthCollege();
        eyes.checkWindow("Clicking Experience Name when menu is open should collapse the menu and change nothing");
    }
}

