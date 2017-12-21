package tests.single.RegressionSuite;

import automationFramework.pages.DarthmouthExperiencePage;
import automationFramework.pages.DarthmouthHomePage;
import automationFramework.pages.DarthmouthRegistrationPage;
import automationFramework.utils.WebDriverUtils;
import org.testng.annotations.Test;
import tests.base.TestBase;

import java.awt.*;

public class C721 extends TestBase {
    private DarthmouthRegistrationPage darthmouthRegistrationPage;
    private DarthmouthExperiencePage darthmouthExperiencePage;
    private DarthmouthHomePage darthmouthHomePage;

    @Test(priority = 1)
    public void VisitedSceneCheckMark() throws AWTException {
        darthmouthRegistrationPage = pageObjectsHandler.getDarthmouthRegistrationPage();
        darthmouthExperiencePage = darthmouthRegistrationPage.closeRegistrationModal();
        darthmouthHomePage = darthmouthExperiencePage.closeExperiencePage();
        darthmouthHomePage.hoverLeftSide(100, 250);
        darthmouthHomePage.selectDartmoutHallScene();
        WebDriverUtils.waitSeconds(2);
        WebDriverUtils.click(800,500);
        darthmouthHomePage.hoverLeftSide(600, 150);
        darthmouthHomePage.hoverLeftSide(100, 350);
        WebDriverUtils.waitSeconds(2);
        eyes.checkWindow("Already visited scene should show check marks on respective scene in scene list");
    }
}
