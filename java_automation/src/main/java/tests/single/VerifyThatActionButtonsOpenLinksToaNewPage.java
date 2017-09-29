package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import automationFramework.pages.base.YouvisitBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.YouvisitBaseTest;

public class VerifyThatActionButtonsOpenLinksToaNewPage extends YouvisitBaseTest {
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void VerifyThatActionButtonsOpenLinksToaNewPage() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookRegistrationPage.navigate();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.waitSevenSeconds();
        stonybrookHomePage.clickOnFirstButton();
        stonybrookHomePage.changeFocusToLastTab();
        Assert.assertTrue(stonybrookHomePage.assertPageIsNotHomePage());
        stonybrookHomePage.closeLastTab();
        stonybrookHomePage.clickOnSecondButton();
        stonybrookHomePage.changeFocusToLastTab();
        Assert.assertTrue(stonybrookHomePage.assertPageIsNotHomePage());
        stonybrookHomePage.closeLastTab();
        stonybrookHomePage.clickOnThirdButton();
        stonybrookHomePage.changeFocusToLastTab();
        Assert.assertTrue(stonybrookHomePage.assertPageIsNotHomePage());
    }
}
