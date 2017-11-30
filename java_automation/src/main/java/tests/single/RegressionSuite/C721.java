package tests.single.RegressionSuite;

import automationFramework.pages.DarthMouthExperiencePage;
import automationFramework.pages.DarthMouthHomePage;
import automationFramework.pages.DarthMouthRegistrationPage;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

import java.awt.*;

public class C721 extends BaseTest {
    private DarthMouthRegistrationPage darthMouthRegistrationPage;
    private DarthMouthExperiencePage darthMouthExperiencePage;
    private DarthMouthHomePage darthMouthHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void VisitedSceneCheckMark() throws AWTException {
        darthMouthRegistrationPage = pageObjectsHandler.getDarthMouthRegistrationPage();
        darthMouthExperiencePage = darthMouthRegistrationPage.closeRegistrattionModal();
        darthMouthHomePage = darthMouthExperiencePage.closeExperiencePage();
        darthMouthHomePage.hoverLeftSide(100, 250);
        darthMouthHomePage.selectDartmoutHallScene();
        WebDriverUtils.waitSeconds(2);
        WebDriverUtils.click(800,500);
        darthMouthHomePage.hoverLeftSide(600, 150);
        darthMouthHomePage.hoverLeftSide(100, 350);
        WebDriverUtils.waitSeconds(2);
        eyes.checkWindow("Already visited scene should show check marks on respective scene in scene list");
    }
}
