package tests.single.RegressionSuite;

import automationFramework.pages.DarthMouthExperiencePage;
import automationFramework.pages.DarthMouthHomePage;
import automationFramework.pages.DarthMouthRegistrationPage;
import automationFramework.utils.WebDriverUtils;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

import java.awt.*;

public class C722 extends BaseTest {
    private DarthMouthRegistrationPage darthMouthRegistrationPage;
    private DarthMouthExperiencePage darthMouthExperiencePage;
    private DarthMouthHomePage darthMouthHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void ScrollSceneList() throws AWTException {
        darthMouthRegistrationPage = pageObjectsHandler.getDarthMouthRegistrationPage();
        darthMouthExperiencePage = darthMouthRegistrationPage.closeRegistrattionModal();
        darthMouthHomePage = darthMouthExperiencePage.closeExperiencePage();
        darthMouthHomePage.hoverLeftSide(100, 250);
        WebDriverUtils.click(0,0);
        WebDriverUtils.waitSeconds(5);
        darthMouthHomePage.scrollToScene("The DEN");
        WebDriverUtils.waitSeconds(20);
        //eyes.checkWindow("Already visited scene should show check marks on respective scene in scene list");
    }
}
