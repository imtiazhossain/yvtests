package tests.single;

import automationFramework.pages.GmailLoginPage;
import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import automationFramework.pages.StonybrookSharePage;
import org.testng.annotations.Test;
import tests.base.TestBase;

import static org.testng.Assert.assertTrue;

public class VerifyEmailShareWorks extends TestBase {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;
    private StonybrookSharePage stonybrookSharePage;
    private GmailLoginPage gmailLoginPage;
    private String recipientEmail = "testingyouvisit@gmail.com";

    @Test(groups = { "SMOKE"})
    public void VerifyEmailShareWorks() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.clickShareDesktopButton();
        eyes.checkRegion(stonybrookHomePage.shareMenu);
        stonybrookSharePage = stonybrookHomePage.clickShareEmail();
        stonybrookSharePage.writeName("Test");
        stonybrookSharePage.writeRecipient(recipientEmail);
        stonybrookSharePage.writeMessage("Testing test message");
        gmailLoginPage = stonybrookSharePage.clickSend();
        assertTrue(stonybrookSharePage.isVerificationDisplayed(), "No success text is shown.");

       /* gmailLoginPage.navigate();
        gmailLoginPage.writeEmail(recipientEmail);
        gmailLoginPage.clickNextEmail();
        gmailLoginPage.writePassword("abstracta");
        GmailInboxPage gmailInboxPage = gmailLoginPage.clickNextPassword();
        Assert.assertTrue(gmailInboxPage.checkIfFirstMailIsFromYouVisit(),"First email was not from youvisit.");
        gmailInboxPage.clickOnYouVisitMail();
        Assert.assertTrue(gmailInboxPage.isMessageTheSame("Testing test message"));
        gmailInboxPage.deleteMail();*/
    }
}
