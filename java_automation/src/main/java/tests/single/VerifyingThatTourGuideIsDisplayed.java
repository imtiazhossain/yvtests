package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class VerifyingThatTourGuideIsDisplayed extends BaseTest {
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(groups = { "SMOKE"})
    public void verifyingThatTourLoads() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        assertTrue(stonybrookHomePage.avatarIsDisplayed(), "Avatar was not displayed on startup.");
    }
}
