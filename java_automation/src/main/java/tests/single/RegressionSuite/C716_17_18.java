package tests.single.RegressionSuite;

import automationFramework.pages.DarthmouthExperiencePage;
import automationFramework.pages.DarthmouthHomePage;
import automationFramework.pages.DarthmouthRegistrationPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

public class C716_17_18 extends TestBase {
    private DarthmouthRegistrationPage darthmouthRegistrationPage;
    private DarthmouthExperiencePage darthmouthExperiencePage;
    private DarthmouthHomePage darthmouthHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void SceneListShownOnHover() {
        darthmouthRegistrationPage = pageObjectsHandler.getDarthmouthRegistrationPage();
        darthmouthExperiencePage = darthmouthRegistrationPage.closeRegistrationModal();
        darthmouthHomePage = darthmouthExperiencePage.closeExperiencePage();
        darthmouthHomePage.hoverLeftSide(100, 250);
//        eyes.checkWindow("Scene list show when hovering over scene list indicator on left");
    }
}

