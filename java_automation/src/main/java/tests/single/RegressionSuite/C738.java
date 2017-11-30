package tests.single.RegressionSuite;

import automationFramework.pages.DarthMouthExperiencePage;
import automationFramework.pages.DarthMouthHomePage;
import automationFramework.pages.DarthMouthRegistrationPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

public class C738 extends BaseTest {
    private DarthMouthRegistrationPage darthMouthRegistrationPage;
    private DarthMouthExperiencePage darthMouthExperiencePage;
    private DarthMouthHomePage darthMouthHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void CurrentSelectionHighlighted () {
        darthMouthRegistrationPage = pageObjectsHandler.getDarthMouthRegistrationPage();
        darthMouthExperiencePage = darthMouthRegistrationPage.closeRegistrattionModal();
        eyes.checkWindow("Current location should be highlighted");
    }
}