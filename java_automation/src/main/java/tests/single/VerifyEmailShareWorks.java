package tests.single;

import automationFramework.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.YouvisitBaseTest;

import static org.testng.Assert.assertTrue;

public class VerifyEmailShareWorks extends YouvisitBaseTest{

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;
    private StonybrookSharePage stonybrookSharePage;
    private GmailLoginPage gmailLoginPage;
    private String recipiantEmail = "testingyouvisit@gmail.com";

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void VerifyEmailShareWorks() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.clickShareDesktopButton();
        stonybrookSharePage = stonybrookHomePage.clickShareEmail();
        stonybrookSharePage.writeName("Test");
        stonybrookSharePage.writeRecipient(recipiantEmail);
        stonybrookSharePage.writeMessage("Testing test message");
        gmailLoginPage = stonybrookSharePage.clickSend();
        assertTrue(stonybrookSharePage.isVerificationDisplayed(), "No success text is shown.");
        gmailLoginPage.navigate();
        gmailLoginPage.writeEmail(recipiantEmail);
        gmailLoginPage.clickNextEmail();
        gmailLoginPage.writePassword("abstracta");
        GmailInboxPage gmailInboxPage = gmailLoginPage.clickNextPassword();
        Assert.assertTrue(gmailInboxPage.checkIfFirstMailIsFromYouVisit(),"First email was not from youvisit.");
        gmailInboxPage.clickOnYouVisitMail();
        Assert.assertTrue(gmailInboxPage.isMessageTheSame("Testing test message"));
        gmailInboxPage.deleteMail();
    }
}
