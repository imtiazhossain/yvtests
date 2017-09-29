package automationFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import automationFramework.pages.base.YouvisitBasePage;
import automationFramework.handlers.YouvisitPageObjectsHandler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StonybrookHomePage extends YouvisitBasePage {

    public StonybrookHomePage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
        if(!this.isLoaded()){
            throw new IllegalStateException("This is not StonybrookHomePage");
        }
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"navigation_F_button\"]")
    WebElement navigateForwardButton;

    @FindBy(how = How.CLASS_NAME, using = "actionButtons")
    WebElement actionButtonsDiv;

    @FindBy(how = How.ID, using = "action_action1")
    WebElement registerNowButton;

    @FindBy(how = How.ID, using = "action_action2")
    WebElement scheduleVisitButton;

    @FindBy(how = How.ID, using = "action_action3")
    WebElement applyOnlineButton;

    public void navigate(){
        driver.get("http://qa.dev.youvisit.com/tour/stonybrook");
    }
    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Experience Stony Brook in Virtual Reality')]");
    }

    public boolean navigateForwardButtonIsDisplayed(){
        return navigateForwardButton.isDisplayed();
    }

    public boolean checkIfTopButtonsArePresent() {
        Point buttonsDiv = actionButtonsDiv.getLocation();
        int ycoord = buttonsDiv.getY();
        int xcoord = buttonsDiv.getX();
        System.out.println(ycoord);
        System.out.println(xcoord);
        if(ycoord!= 0) {
            return false;
        }
        return true;
    }
    public void waitSevenSeconds() throws InterruptedException {
        Thread.sleep(7000);
    }

    public void clickOnFirstButton() {
        registerNowButton.click();
    }

    public boolean assertPageIsNotHomePage() {
        if(driver.getCurrentUrl().contentEquals("http://www.youvisit.com/tour/stonybrook")){
            return false;
        }
        return true;
    }

    public void clickOnSecondButton() {
        scheduleVisitButton.click();
    }

    public void changeFocusToLastTab() {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }

    public void closeLastTab() {
        driver.close();
        changeFocusToLastTab();
    }

    public void clickOnThirdButton() {
        applyOnlineButton.click();
    }
}
