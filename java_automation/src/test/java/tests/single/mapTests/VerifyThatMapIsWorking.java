package tests.single.mapTests;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class VerifyThatMapIsWorking extends TestBase {
        public StonybrookRegistrationPage stonybrookRegistrationPage;
        public StonybrookHomePage stonybrookHomePage;

        @Test
        public void VerifyThatMapIsWorking(){
            stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
            stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
            String sceneDescription = stonybrookHomePage.getSceneDescriptionText();
            Assert.assertTrue(stonybrookHomePage.checkMiniMapIsPresent());
            int heightMapSmall = stonybrookHomePage.returnMapHeight();
            int widthMapSmall = stonybrookHomePage.returnMapWidth();
            stonybrookHomePage.hoverOnMiniMap();
            int heightMapBig = stonybrookHomePage.returnMapHeight();
            int widthMapBig = stonybrookHomePage.returnMapWidth();
            Assert.assertTrue(heightMapSmall<heightMapBig && widthMapSmall<widthMapBig, "Map was same size on hover.");
            stonybrookHomePage.clickOnExpandMap();
            int heightMapMax = stonybrookHomePage.returnMapHeight();
            int widthMapMax = stonybrookHomePage.returnMapWidth();
            Assert.assertTrue(heightMapBig<heightMapMax && widthMapBig<widthMapMax, "Map was same size after clicking fullscreen");
            Assert.assertTrue(stonybrookHomePage.checkIfCampusMapIsPresent());
        }
}

