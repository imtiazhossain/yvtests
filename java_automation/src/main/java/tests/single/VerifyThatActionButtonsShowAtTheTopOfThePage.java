package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.YouvisitBaseTest;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class VerifyThatActionButtonsShowAtTheTopOfThePage extends YouvisitBaseTest {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void VerifyThatActionButtonsShowAtTheTopOfThePage() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.waitSevenSeconds();
        Assert.assertTrue(stonybrookHomePage.checkIfTopButtonsArePresent());

    }
}
