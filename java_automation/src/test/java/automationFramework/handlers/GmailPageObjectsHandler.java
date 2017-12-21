package automationFramework.handlers;

import automationFramework.pages.GmailInboxPage;
import automationFramework.pages.GmailLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailPageObjectsHandler extends PageObjectsHandler {

    private static GmailPageObjectsHandler instance = null;

    private GmailInboxPage gmailInboxPage;
    private GmailLoginPage gmailLoginPage;

    protected GmailPageObjectsHandler(WebDriver driver) {
        super(driver);
    }

    public static GmailPageObjectsHandler getInstance(WebDriver driver) {

        if (instance == null) {
            instance = new GmailPageObjectsHandler(driver);
        }

        return instance;
    }

    public GmailInboxPage getGmailInboxPage() {

        if (gmailInboxPage == null) {
            gmailInboxPage = new GmailInboxPage(driver, instance);
            PageFactory.initElements(driver, gmailInboxPage);
        }

        return gmailInboxPage;
    }

    public GmailLoginPage getGmailLoginPage() {

        if (gmailLoginPage == null) {
            gmailLoginPage = new GmailLoginPage(driver, instance);
            PageFactory.initElements(driver, gmailLoginPage);
        }

        return gmailLoginPage;
    }

    public static void setInstanceNull() {

        instance = null;
    }
}
