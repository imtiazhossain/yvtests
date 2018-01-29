package automationFramework.handlers;

import automationFramework.pages.*;
import automationFramework.utils.GetProperties;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageObjectsHandler extends WebDriverUtils{

    protected static WebDriver driver;
    private static PageObjectsHandler instance;

    private StonybrookHomePage stonybrookHomePage;
    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookSharePage stonybrookSharePage;
    private SwarovskiPage swarovskiPage;
    private RenaissancePage renaissancePage;
    private ActNowPromptPage actNowPromptPage;
    private DarthmouthRegistrationPage darthmouthRegistrationPage;
    private DarthmouthHomePage darthmouthHomePage;
    private IubRegistrationPage iubRegistrationPage;
    protected GetProperties entrypointProperties = new GetProperties("ENTRYPOINT");

    protected PageObjectsHandler(WebDriver driver) {
        PageObjectsHandler.driver = driver;
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
            String newurl = url + entrypointProperties.getString("STONYBROOK");
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

    public RenaissancePage getRenaissancePage() {

        if (renaissancePage == null) {
            renaissancePage = new RenaissancePage(driver);
            String url = driver.getCurrentUrl();
            String newurl = url + entrypointProperties.getString("RENAISSANCE");
            driver.get(newurl);
            PageFactory.initElements(driver, renaissancePage);
        }

        return renaissancePage;
    }

    public ActNowPromptPage getActNowPromptPage() {
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ctaButtonArea')]")));
        if (actNowPromptPage == null) {
            actNowPromptPage = new ActNowPromptPage(driver);
            PageFactory.initElements(driver, actNowPromptPage);
        }

        return actNowPromptPage;
    }

    public DarthmouthRegistrationPage getDarthmouthRegistrationPage() {

        if (darthmouthRegistrationPage == null) {
            darthmouthRegistrationPage = new DarthmouthRegistrationPage(driver);
            String url = driver.getCurrentUrl();
            String newurl = url + entrypointProperties.getString("DARTHMOUTH");
            driver.get(newurl);
            PageFactory.initElements(driver, darthmouthRegistrationPage);
        }

        return darthmouthRegistrationPage;
    }

    public DarthmouthHomePage getDarthmouthHomePage() {

        if (darthmouthHomePage == null) {
            darthmouthHomePage = new DarthmouthHomePage(driver);
            PageFactory.initElements(driver, DarthmouthHomePage.class);
        }

        return darthmouthHomePage;
    }

    public IubRegistrationPage getIubRegistrationPage() {

        if (iubRegistrationPage == null) {
            iubRegistrationPage = new IubRegistrationPage(driver);
            String url = driver.getCurrentUrl();
            String newurl = url + entrypointProperties.getString("IUB");
            driver.get(newurl);
            PageFactory.initElements(driver, iubRegistrationPage);
        }

        return iubRegistrationPage;
    }

    public static void setInstanceNull() {

        instance = null;
    }
}