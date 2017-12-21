package automationFramework.utils;

import automationFramework.utils.datatypes.Wait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.base.TestBase;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static automationFramework.utils.Constants.*;

public class WebDriverUtils extends TestBase{

    public static WebElement getElementWhenClickeable(WebElement element, int timeout, WebDriver driver) {
        new WebDriverWait(driver, timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(element));

        return element;
    }

    public static boolean isElementPresent(WebDriver driver, final By Locator) {
        boolean oAux = true;

        try {
            driver.findElement(Locator);

        } catch (NoSuchElementException e) {
            oAux = false;
        }

        return oAux;
    }

    public static boolean isElementPresent(WebDriver driver, WebElement element) {
        boolean oAux = true;


        (new WebDriverWait(driver, Constants.TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.isDisplayed();

        } catch (NoSuchElementException e) {
            oAux = false;
        }

        return oAux;
    }


    public static void waitTime(WebDriver driver, int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void addWait(WebDriver driver, Wait wait) {
        switch (wait) {
            case LONG_WAIT:
                waitTime(driver, LONG_TIMEOUT);
                break;
            case MEDIUM_WAIT:
                waitTime(driver, TIMEOUT);
                break;
            case SHORT_WAIT:
                waitTime(driver, SHORT_TIMEOUT);
                break;
            default:
                waitTime(driver, SHORT_TIMEOUT);
                break;
        }
    }

    public static WebElement findElement(WebDriver driver, final By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (NoSuchElementException e) {
            System.err.print(e.getMessage());
        }
        return element;
    }

    public static List<WebElement> findElements(WebDriver driver, final By locator) {
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(locator);
        } catch (NoSuchElementException e) {
            System.err.print(e.getMessage());
        }
        return elements;
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void selectByText(WebElement comboBox, String text) {
        if (!text.isEmpty()) {
            Select select = new Select(comboBox);
            select.selectByVisibleText(text);
        }
    }

    public static void selectByValue(WebElement comboBox, String value) {
        if (!value.isEmpty()) {
            Select select = new Select(comboBox);
            select.selectByValue(value);
        }
    }

    public static boolean isChecked(WebElement check) {
        return check.getAttribute("checked") != null;
    }

    public static void checkElement(WebElement check) {
        boolean isChecked = isChecked(check);
        if (isChecked) return;
        check.click();
    }

    public static void clear(WebElement element) {
        element.clear();
    }

    public static void sendText(WebElement element, String text) {
        clear(element);
        element.sendKeys(text);
    }

    public static void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToBottomofPage(WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    public static void mouseoverElement(WebDriver driver, WebElement element) {

        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public static void click(int x, int y) throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void closePopUpWhenPresent(WebDriver driver) {

        int i = 0;
        while (i < 120) {
            if (WebDriverUtils.isElementPresent(driver, By.xpath("//div/img[contains(@class,'closeButton')]"))) {
                //WebDriverUtils.click(driver,By.xpath("(//div[contains(@class,'closeButton')]/img)[2]"));
                driver.navigate().refresh();
                break;
            } else {
                WebDriverUtils.waitSeconds(1);
                i++;
            }
        }
        WebDriverUtils.waitSeconds(10);
    }

    public static void click(WebDriver driver, By locator) {

        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void pressKey (WebDriver driver, Keys key){

        driver.findElement(By.tagName("body")).sendKeys(key);
    }
}


