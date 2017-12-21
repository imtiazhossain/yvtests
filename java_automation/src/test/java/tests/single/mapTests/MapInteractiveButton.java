package tests.single.mapTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MapInteractiveButton extends VerifyThatMapIsWorking {

    @Test
    public void VerifyThatMapIsWorking(){
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        Assert.assertTrue(stonybrookHomePage.checkMiniMapIsPresent());
        stonybrookHomePage.hoverOnMiniMap();
//        eyes.checkRegion(stonybrookHomePage.miniMapDiv);
        Assert.assertTrue(stonybrookHomePage.checkInteractiveMapButtonIsPresent());
    }
}
