package tests.single;

import automationFramework.pages.RenaissancePage;
import org.testng.annotations.Test;
import tests.base.TestBase;

public class IntroVideoTests extends TestBase {

    private RenaissancePage renaissancePage;

    @Test(groups = { "SMOKE"})
    public void checkIntroVideoLoad() throws Exception {
        renaissancePage = pageObjectsHandler.getRenaissancePage();
        renaissancePage.getPageLoadedLocator();
        renaissancePage.introVideo();
        renaissancePage.playButton();
    }
}

