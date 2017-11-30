package tests.single.RegressionSuite;

import automationFramework.pages.DarthMouthExperiencePage;
import automationFramework.pages.DarthMouthHomePage;
import automationFramework.pages.DarthMouthRegistrationPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

public class C716_17_18 extends BaseTest {
    private DarthMouthRegistrationPage darthMouthRegistrationPage;
    private DarthMouthExperiencePage darthMouthExperiencePage;
    private DarthMouthHomePage darthMouthHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void SceneListShownOnHover() {
        darthMouthRegistrationPage = pageObjectsHandler.getDarthMouthRegistrationPage();
        darthMouthExperiencePage = darthMouthRegistrationPage.closeRegistrattionModal();
        darthMouthHomePage = darthMouthExperiencePage.closeExperiencePage();
        darthMouthHomePage.hoverLeftSide(100, 250);
        eyes.checkWindow("Scene list show when hovering over scene list indicator on left");
    }
}

