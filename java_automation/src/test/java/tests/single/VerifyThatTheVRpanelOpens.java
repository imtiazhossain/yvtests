package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class VerifyThatTheVRpanelOpens extends TestBase {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Test
    public void VerifyThatTheVRpanelOpens() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.clickOnVRButton();
        Assert.assertTrue(stonybrookHomePage.checkIfVRpanelIsPresent());
        stonybrookHomePage.closeVRpanel();
        Assert.assertTrue(!stonybrookHomePage.checkIfVRpanelIsPresent());
    }
}
