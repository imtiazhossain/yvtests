package automationFramework.handlers;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import automationFramework.pages.StonybrookSharePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsHandler {

    protected static WebDriver driver;
    private static PageObjectsHandler instance;

    private StonybrookHomePage stonybrookHomePage;
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookSharePage stonybrookSharePage;

    protected PageObjectsHandler(WebDriver driver) {
        this.driver = driver;
    }

    public static PageObjectsHandler getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new PageObjectsHandler(driver);
        }
        return instance;
    }


    public StonybrookHomePage getStonybrookHomePage() {
        if (stonybrookHomePage == null) {
            stonybrookHomePage = new StonybrookHomePage(driver);
            PageFactory.initElements(driver, stonybrookHomePage);
        }
        return stonybrookHomePage;
    }

    public StonybrookSharePage getStonybrookSharePage() {

        if (stonybrookSharePage == null) {
            stonybrookSharePage = new StonybrookSharePage(driver);
            PageFactory.initElements(driver, stonybrookSharePage);
        }

        return stonybrookSharePage;
    }

    public StonybrookRegistrationPage getStonybrookRegistrationPage() {

        if (stonybrookRegistrationPage == null) {
            stonybrookRegistrationPage = new StonybrookRegistrationPage(driver);
            PageFactory.initElements(driver, stonybrookRegistrationPage);
        }

        return stonybrookRegistrationPage;
    }

    public static void setInstanceNull() {

        instance = null;
    }

}
