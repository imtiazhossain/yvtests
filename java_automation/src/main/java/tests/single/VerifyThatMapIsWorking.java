package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.YouvisitBaseTest;

public class VerifyThatMapIsWorking extends YouvisitBaseTest{
        private StonybrookRegistrationPage stonybrookRegistrationPage;
        private StonybrookHomePage stonybrookHomePage;

        @Severity(SeverityLevel.NORMAL)
        @Test
        public void VerifyThatMapIsWorking(){
            stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
            stonybrookRegistrationPage.navigate();
            stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
            String sceneDescription = stonybrookHomePage.getSceneDescriptionText();
            Assert.assertTrue(stonybrookHomePage.checkMiniMapIsPresent());
            int heightMapSmall = stonybrookHomePage.returnMapHeight();
            int widthMapSmall = stonybrookHomePage.returnMapWidth();
            stonybrookHomePage.hoverOnMiniMap();
            int heightMapBig = stonybrookHomePage.returnMapHeight();
            int widthMapBig = stonybrookHomePage.returnMapWidth();
            Assert.assertTrue(heightMapSmall<heightMapBig && widthMapSmall<widthMapBig);
            stonybrookHomePage.clickOnExpandMap();
            int heightMapMax = stonybrookHomePage.returnMapHeight();
            int widthMapMax = stonybrookHomePage.returnMapWidth();
            Assert.assertTrue(heightMapBig<heightMapMax && widthMapBig<widthMapMax);
            Assert.assertTrue(stonybrookHomePage.checkIfCampusMapIsPresent());
            stonybrookHomePage.clickMarkOnMap();
            String sceneDescriptionChanged = stonybrookHomePage.getSceneDescriptionText();
            Assert.assertTrue(sceneDescription!= sceneDescriptionChanged);
        }
}

