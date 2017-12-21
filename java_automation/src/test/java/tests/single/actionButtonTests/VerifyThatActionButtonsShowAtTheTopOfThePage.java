package tests.single.actionButtonTests;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class VerifyThatActionButtonsShowAtTheTopOfThePage extends TestBase {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Test
    public void VerifyThatActionButtonsShowAtTheTopOfThePage() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.waitForActionButtons();
        Assert.assertTrue(stonybrookHomePage.checkIfTopButtonsArePresent());

    }
}
