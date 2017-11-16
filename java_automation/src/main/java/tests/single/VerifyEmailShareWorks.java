package tests.single;

import automationFramework.pages.*;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class VerifyEmailShareWorks extends BaseTest {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;
    private StonybrookSharePage stonybrookSharePage;
    private GmailLoginPage gmailLoginPage;
    private String recipientEmail = "testingyouvisit@gmail.com";

    @Severity(SeverityLevel.NORMAL)
    @Test(groups = { "SMOKE"})
    public void VerifyEmailShareWorks() throws Exception {
        Eyes eyes = new Eyes();
        eyes.setApiKey("Ca0uy5Nkl2XEWFKtWMk99NZvuKuihv5aM100V102lmYhEBA110");
        eyes.open(driver, "Hello World!", "My first Selenium Java test!",
                new RectangleSize(800, 600));

        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        stonybrookHomePage.clickShareDesktopButton();
        eyes.checkWindow("Hello!");
        stonybrookSharePage = stonybrookHomePage.clickShareEmail();
        stonybrookSharePage.writeName("Test");
        stonybrookSharePage.writeRecipient(recipientEmail);
        stonybrookSharePage.writeMessage("Testing test message");
        gmailLoginPage = stonybrookSharePage.clickSend();
        assertTrue(stonybrookSharePage.isVerificationDisplayed(), "No success text is shown.");
        eyes.close();
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
