package tests.single.RegressionSuite;

import automationFramework.pages.DarthMouthExperiencePage;
import automationFramework.pages.DarthMouthHomePage;
import automationFramework.pages.DarthMouthRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

public class C741 extends BaseTest {
    private DarthMouthRegistrationPage darthMouthRegistrationPage;
    private DarthMouthExperiencePage darthMouthExperiencePage;
    private DarthMouthHomePage darthMouthHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void SelectDifferentExperience() {
        darthMouthRegistrationPage = pageObjectsHandler.getDarthMouthRegistrationPage();
        darthMouthExperiencePage = darthMouthRegistrationPage.closeRegistrattionModal();
        darthMouthHomePage = darthMouthExperiencePage.closeExperiencePage();
        darthMouthHomePage.navigateToExperiences().selectAthleticExperience();

        Assert.assertTrue(darthMouthHomePage.isDarthMouthAthleticsExpLoaded(), "New  selected Experience did not load");
    }
}