package tests.single;

import automationFramework.pages.RenaissancePage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

public class IntroVideoTests extends TestBase {

    private RenaissancePage renaissancePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(groups = { "SMOKE"})
    public void checkIntroVideoLoad() throws Exception {
        renaissancePage = pageObjectsHandler.getRenaissancePage();
        renaissancePage.getPageLoadedLocator();
        renaissancePage.introVideo();
//        renaissancePage.playButton();
    }
}

