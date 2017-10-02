package automationFramework.handlers;

import automationFramework.pages.*;
import com.applitools.eyes.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class YouvisitPageObjectsHandler extends PageObjectsHandler {

    private static YouvisitPageObjectsHandler instance = null;

    private StonybrookHomePage stonybrookHomePage;
    private StonybrookRegistrationPage stonybrookRegistrationPage;

    protected YouvisitPageObjectsHandler(WebDriver driver, Eyes eyes) {
        super(driver, eyes);
    }

    public static YouvisitPageObjectsHandler getInstance(WebDriver driver, Eyes eyes) {
        if (instance == null) {
            instance = new YouvisitPageObjectsHandler(driver, eyes);
        }
        return instance;
    }

    public StonybrookHomePage getStonybrookHomePage() {
        if (stonybrookHomePage == null) {
            stonybrookHomePage = new StonybrookHomePage(driver, instance);
            PageFactory.initElements(driver, stonybrookHomePage);
            stonybrookHomePage.setEyes(eyes);
        }
        return stonybrookHomePage;
    }

    public StonybrookRegistrationPage getStonybrookRegistrationPage(){
        if (stonybrookRegistrationPage == null){
            stonybrookRegistrationPage = new StonybrookRegistrationPage(driver, instance);
            PageFactory.initElements(driver, stonybrookRegistrationPage);
        }
        return stonybrookRegistrationPage;
    }

    public static void setInstanceNull() {

        instance = null;
    }
}
