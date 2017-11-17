package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import automationFramework.utils.WebDriverUtils;
import automationFramework.utils.datatypes.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

public class VerifyButtons extends BaseTest {
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void VerifyActNowPromptAreaIsDisplayed() {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();

        WebDriverUtils.addWait(driver, Wait.MEDIUM_WAIT);
        Assert.assertTrue(stonybrookHomePage.isInformationButtonDisplayed(), "'Information' button is Not displayed");
        Assert.assertTrue(stonybrookHomePage.isAudioButtonDisplayed(), "'Audio' button is Not displayed");
        Assert.assertTrue(stonybrookHomePage.islanguageBtnDisplayed(), "'Language' button is Not displayed");
        Assert.assertTrue(stonybrookHomePage.isSupplementalMediaButtonDisplayed(), "'Supplemental Media' is Not displayed");
        Assert.assertTrue(stonybrookHomePage.isFullScreenButtonDisplayed(), "'Full Screen' button is Not displayed");
    }
}