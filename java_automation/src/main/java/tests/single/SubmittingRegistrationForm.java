package tests.single;

import automationFramework.pages.StonybrookPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.YouvisitBaseTest;

import static org.testng.Assert.assertTrue;

public class SubmittingRegistrationForm extends YouvisitBaseTest{
    private StonybrookPage stonybrookPage;


    @Severity(SeverityLevel.NORMAL)
    @Test
    public void submittingRegistrationForm() throws Exception {
        stonybrookPage = pageObjectsHandler.getStonybrookPage();
        stonybrookPage.navigate();
        stonybrookPage.getPageLoadedLocator();
        stonybrookPage.clickImA();
        stonybrookPage.clickOptionProspectiveStudent();
        stonybrookPage.clickOptionHighSchoolGraduate();
        stonybrookPage.writeCompleteName("testing","testing");
        stonybrookPage.writeEmail("testing182kmsy2Aakj@gmail.com");
        stonybrookPage.selectEnrollmentYear("2017");
        stonybrookPage.selectMajor("Computer Engineering");
        stonybrookPage.selectGender("Male");
        stonybrookPage.writeDateOfBirth("11/22/1993");
        stonybrookPage.writePhone("+59892555555");
        stonybrookPage.selectCountry("Uruguay");
    }
}
