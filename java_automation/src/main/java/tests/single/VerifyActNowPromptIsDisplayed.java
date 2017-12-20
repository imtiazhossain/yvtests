package tests.single;

import automationFramework.pages.ActNowPromptPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

public class VerifyActNowPromptIsDisplayed extends TestBase {
    private ActNowPromptPage actNowPromptPage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void VerifyActNowPromptAreaIsDisplayed() {
        pageObjectsHandler.getStonybrookRegistrationPage().clickExitButton();
        actNowPromptPage = pageObjectsHandler.getActNowPromptPage();
        Assert.assertTrue(actNowPromptPage.isActNowPromptDisplayed(), "Act Now Prompt is Not displayed");
        Assert.assertTrue(actNowPromptPage.isRegisterNowButtonDisplayed(), "Act Now 'Register Now' button is Not displayed");
        Assert.assertTrue(actNowPromptPage.isScheduleButtonVisitDisplayed(), "Act Now 'Schedule Visit' button is Not displayed");
        Assert.assertTrue(actNowPromptPage.isApplyOnlineButtonDisplayed(), "Act Now 'Apply Online' button is Not displayed");
        Assert.assertTrue(actNowPromptPage.isCloseButtonDisplayed(), "Act Now 'Close' button is Not displayed");
    }

//    @Severity(SeverityLevel.NORMAL)
//    @Test(priority = 2)
//    public void VerifyActNowPromptOptionsAreDisplayed() {
//        System.out.println("act now found");
//        Assert.assertTrue(actNowPromptPage.isRegisterNowButtonDisplayed(), "Act Now 'Register Now' button is Not displayed");
//        Assert.assertTrue(actNowPromptPage.isScheduleButtonVisitDisplayed(), "Act Now 'Schedule Visit' button is Not displayed");
//        Assert.assertTrue(actNowPromptPage.isApplyOnlineButtonDisplayed(), "Act Now 'Apply Online' button is Not displayed");
//        Assert.assertTrue(actNowPromptPage.isCloseButtonDisplayed(), "Act Now 'Close' button is Not displayed");
//    }
}