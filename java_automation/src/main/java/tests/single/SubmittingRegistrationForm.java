package tests.single;

import automationFramework.pages.StonybrookRegistrationPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.YouvisitBaseTest;

import static org.testng.Assert.assertTrue;

public class SubmittingRegistrationForm extends YouvisitBaseTest{
    private StonybrookRegistrationPage stonybrookRegistrationPage;


    @Severity(SeverityLevel.NORMAL)
    @Test
    public void submittingRegistrationForm() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookRegistrationPage.navigate();
        stonybrookRegistrationPage.getPageLoadedLocator();
        stonybrookRegistrationPage.clickImA();
        stonybrookRegistrationPage.clickOptionProspectiveStudent();
        stonybrookRegistrationPage.clickOptionHighSchoolGraduate();
        stonybrookRegistrationPage.writeCompleteName("testing","testing");
        stonybrookRegistrationPage.writeEmail("testingyv+" + Math.random() + "@gmail.com");
        stonybrookRegistrationPage.selectEnrollmentYear("2017");
        stonybrookRegistrationPage.writeAndSelectCurrentSchool("Dodgeville high school");
        stonybrookRegistrationPage.selectMajor("Computer Engineering");
        stonybrookRegistrationPage.selectGender("Male");
        stonybrookRegistrationPage.selectDateOfBirth("1996", "Nov", "3");
        stonybrookRegistrationPage.writePhone("+59892555555");
        stonybrookRegistrationPage.selectCountry("Uruguay");
        stonybrookRegistrationPage.submitForm();
        assertTrue(stonybrookRegistrationPage.getConfirmationMessageDisplayed(),
                "After submitting registration user was not shown the confirmation screen.");

    }
}
