package tests.single.RegressionSuite;

import automationFramework.pages.DarthmouthExperiencePage;
import automationFramework.pages.DarthmouthHomePage;
import automationFramework.pages.DarthmouthRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class C720 extends TestBase {
    private DarthmouthRegistrationPage darthmouthRegistrationPage;
    private DarthmouthExperiencePage darthmouthExperiencePage;
    private DarthmouthHomePage darthmouthHomePage;

    @Test(priority = 1)
    public void SceneListShownOnHover() {
        darthmouthRegistrationPage = pageObjectsHandler.getDarthmouthRegistrationPage();
        darthmouthExperiencePage = darthmouthRegistrationPage.closeRegistrationModal();
        darthmouthHomePage = darthmouthExperiencePage.closeExperiencePage();
        darthmouthHomePage.hoverLeftSide(100, 250);
        darthmouthHomePage.hoverScene();
        darthmouthHomePage.selectDartmoutHallScene();
        Assert.assertTrue(darthmouthHomePage.wasDartmoutHallSceneSelected(), "Scene was not selected");
    }
}

