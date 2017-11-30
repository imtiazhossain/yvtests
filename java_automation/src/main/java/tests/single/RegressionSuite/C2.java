package tests.single.RegressionSuite;

import automationFramework.pages.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

public class C2 extends BaseTest {
    private DarthMouthRegistrationPage darthMouthRegistrationPage;
    private DarthMouthExperiencePage darthMouthExperiencePage;
    private DarthMouthHomePage darthMouthHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1)
    public void SelectExperience() {
        darthMouthRegistrationPage = pageObjectsHandler.getDarthMouthRegistrationPage();
        darthMouthExperiencePage = darthMouthRegistrationPage.closeRegistrattionModal();
        darthMouthHomePage = darthMouthExperiencePage.closeExperiencePage();

        darthMouthHomePage.navigateToExperiences().selectAthleticExperience();

    }
}