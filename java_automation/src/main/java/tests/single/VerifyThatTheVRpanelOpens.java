package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.YouvisitBaseTest;

public class VerifyThatTheVRpanelOpens extends YouvisitBaseTest{

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void VerifyThatTheVRpanelOpens() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookRegistrationPage.navigate();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.clickOnVRButton();
        Assert.assertTrue(stonybrookHomePage.checkIfVRpanelIsPresent());
        stonybrookHomePage.closeVRpanel();
        Assert.assertTrue(!stonybrookHomePage.checkIfVRpanelIsPresent());
    }
}
