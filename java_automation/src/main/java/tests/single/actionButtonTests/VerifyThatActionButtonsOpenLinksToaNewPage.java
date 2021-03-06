package tests.single.actionButtonTests;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

public class VerifyThatActionButtonsOpenLinksToaNewPage extends TestBase {
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void VerifyThatActionButtonsOpenLinksToaNewPage() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.waitForActionButtons();
        stonybrookHomePage.clickOnFirstButton();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.clickOnSecondButton();
        stonybrookHomePage.changeFocusToLastTab();
        Assert.assertTrue(stonybrookHomePage.assertPageIsNotHomePage());
        stonybrookHomePage.closeLastTab();
        stonybrookHomePage.clickOnThirdButton();
        stonybrookHomePage.changeFocusToLastTab();
        Assert.assertTrue(stonybrookHomePage.assertPageIsNotHomePage());
    }
}
