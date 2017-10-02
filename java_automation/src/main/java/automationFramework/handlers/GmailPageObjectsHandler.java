package automationFramework.handlers;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import com.applitools.eyes.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailPageObjectsHandler extends PageObjectsHandler {

    private static GmailPageObjectsHandler instance = null;

    private StonybrookHomePage stonybrookHomePage;
    private StonybrookRegistrationPage stonybrookRegistrationPage;

    protected GmailPageObjectsHandler(WebDriver driver, Eyes eyes) {
        super(driver, eyes);
    }

    public static GmailPageObjectsHandler getInstance(WebDriver driver, Eyes eyes) {
        if (instance == null) {
            instance = new GmailPageObjectsHandler(driver, eyes);
        }
        return instance;
    }



    public static void setInstanceNull() {

        instance = null;
    }
}
