package tests.single;

import automationFramework.pages.ActNowPromptPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class VerifyActNowPromptIsDisplayed extends TestBase {
    private ActNowPromptPage actNowPromptPage;

    @Test(priority = 1)
    public void VerifyActNowPromptIsDisplayed() {
        pageObjectsHandler.getStonybrookRegistrationPage().clickExitButton();
        actNowPromptPage = pageObjectsHandler.getActNowPromptPage();
        Assert.assertTrue(actNowPromptPage.isActNowPromptDisplayed(), "Act Now Prompt is Not displayed");
        Assert.assertTrue(actNowPromptPage.isRegisterNowButtonDisplayed(), "Act Now 'Register Now' button is Not displayed");
        Assert.assertTrue(actNowPromptPage.isScheduleButtonVisitDisplayed(), "Act Now 'Schedule Visit' button is Not displayed");
        Assert.assertTrue(actNowPromptPage.isApplyOnlineButtonDisplayed(), "Act Now 'Apply Online' button is Not displayed");
        Assert.assertTrue(actNowPromptPage.isCloseButtonDisplayed(), "Act Now 'Close' button is Not displayed");
    }
}