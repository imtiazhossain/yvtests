package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

public class VerifyThatTheVRpanelOpens extends BaseTest {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
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
