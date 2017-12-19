package tests.single.mapTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class MapInteractiveButton extends VerifyThatMapIsWorking {

    @Severity(SeverityLevel.NORMAL)
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
