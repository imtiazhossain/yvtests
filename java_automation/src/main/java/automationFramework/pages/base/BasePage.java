package automationFramework.pages.base;

import automationFramework.handlers.PageObjectsHandler;
import automationFramework.utils.GetProperties;
import automationFramework.utils.WebDriverUtils;
import automationFramework.utils.datatypes.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static automationFramework.utils.Utils.applyDefaultIfMissing;

public abstract class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private static String environment = applyDefaultIfMissing(System.getProperty("environment"), "PROD");
    protected static GetProperties properties = new GetProperties(environment);
    protected static PageObjectsHandler pageObjectsHandler;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        addWait(Wait.SHORT_WAIT);
        BasePage.wait = new WebDriverWait(driver, 30);
        pageObjectsHandler = PageObjectsHandler.getInstance(driver);
    }

    public void addWait(Wait wait) {
        WebDriverUtils.addWait(driver, wait);
    }

    public WebElement findElement(final By locator) {
        return WebDriverUtils.findElement(driver, locator);
    }

    public List<WebElement> findElements(final By locator) {
        return WebDriverUtils.findElements(driver, locator);
    }

    public void scrollToElement(WebElement element) {
        WebDriverUtils.scrollToElement(driver, element);
    }

    public void selectByText(WebElement select, String text) {
        WebDriverUtils.selectByText(select, text);
    }

    public void selectByValue(WebElement select, String text) {
        WebDriverUtils.selectByValue(select, text);
    }

    public boolean isChecked(WebElement check) {
        return WebDriverUtils.isChecked(check);
    }

    public void checkElement(WebElement check) {
        WebDriverUtils.checkElement(check);
    }

    public void clear(WebElement element) {
        WebDriverUtils.clear(element);
    }

    public void sendText(WebElement element, String text) {
        WebDriverUtils.sendText(element, text);
    }

    protected final boolean isLoaded() {
        return WebDriverUtils.isElementPresent(driver, this.getPageLoadedLocator());
    }

    public abstract By getPageLoadedLocator();

}
