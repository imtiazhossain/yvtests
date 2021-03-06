package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

import static org.testng.Assert.assertTrue;

public class VerifyScenePanelOpensOnHover extends TestBase {
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void verifyingThatTourLoads() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        Thread.sleep(5000);
        stonybrookHomePage.hoverOverTourNamesActivation();
        assertTrue(stonybrookHomePage.stopsListIsDisplayed(), "Navigate forward button was not detected.");
    }
}
