package automationFramework.handlers;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import automationFramework.pages.StonybrookSharePage;
import automationFramework.pages.SwarovskiPage;
import automationFramework.utils.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsHandler {

    protected static WebDriver driver;
    private static PageObjectsHandler instance;

    private StonybrookHomePage stonybrookHomePage;
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookSharePage stonybrookSharePage;
    private SwarovskiPage swarovskiPage;
    protected GetProperties entrypointProperties = new GetProperties("ENTRYPOINT");

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
            String url = driver.getCurrentUrl();
            String newurl = url+ entrypointProperties.getString("STONYBROOK");
            driver.get(newurl);
            PageFactory.initElements(driver, stonybrookRegistrationPage);
        }

        return stonybrookRegistrationPage;
    }

    public SwarovskiPage getSwarovskiPage() {

        if (swarovskiPage == null) {
            swarovskiPage = new SwarovskiPage(driver);
            String url = driver.getCurrentUrl();
            String newurl = url + entrypointProperties.getString("SWAROVSKI");
            driver.get(newurl);
            PageFactory.initElements(driver, swarovskiPage);
        }

        return swarovskiPage;
    }


    public static void setInstanceNull() {

        instance = null;
    }

}
