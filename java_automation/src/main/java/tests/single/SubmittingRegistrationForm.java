package tests.single;

import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

import static org.testng.Assert.assertTrue;

public class SubmittingRegistrationForm extends TestBase {
    private StonybrookRegistrationPage stonybrookRegistrationPage;


    @Severity(SeverityLevel.NORMAL)
    @Test(groups = { "SMOKE"})
    public void submittingRegistrationForm() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookRegistrationPage.getPageLoadedLocator();
        stonybrookRegistrationPage.clickContInBrowser();
        stonybrookRegistrationPage.clickStart();
        stonybrookRegistrationPage.clickImA();
        stonybrookRegistrationPage.clickOptionProspectiveStudent();
        stonybrookRegistrationPage.clickOptionHighSchoolGraduate();
        stonybrookRegistrationPage.writeCompleteName("testing","testing");
        stonybrookRegistrationPage.writeEmail("testingyv+" + Math.random() + "@gmail.com");
        stonybrookRegistrationPage.selectEnrollmentYear("2020");
        stonybrookRegistrationPage.writeAndSelectCurrentSchool("Dodgeville high school");
        stonybrookRegistrationPage.selectMajor("Computer Engineering");
        stonybrookRegistrationPage.selectGender("Male");
        stonybrookRegistrationPage.selectDateOfBirth("1996", "Nov", "3");
        stonybrookRegistrationPage.writePhone("+59892555555");
        stonybrookRegistrationPage.selectCountry("Canada");
        stonybrookRegistrationPage.submitForm();
        assertTrue(stonybrookRegistrationPage.getConfirmationMessageDisplayed(),
                "After submitting registration user was not shown the confirmation screen.");

    }
}
