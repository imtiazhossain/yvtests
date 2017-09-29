package automationFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automationFramework.pages.base.YouvisitBasePage;
import automationFramework.handlers.YouvisitPageObjectsHandler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StonybrookHomePage extends YouvisitBasePage {

    public StonybrookHomePage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
        if(!this.isLoaded()){
            throw new IllegalStateException("This is not StonybrookHomePage");
        }
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"navigation_F_button\"]")
    WebElement navigateForwardButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"avatar\"]")
    WebElement avatar;
    @FindBy(how = How.CSS, using = ".activationZone")
    WebElement tourNamesActivation;


    public void navigate(){
        driver.get("http://qa.dev.youvisit.com/tour/stonybrook");
    }
    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Experience Stony Brook in Virtual Reality')]");
    }


    public boolean navigateForwardButtonIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(avatar));
        return navigateForwardButton.isDisplayed();
    }

    public boolean avatarIsDisplayed(){
        return avatar.isDisplayed();
    }
    public void hoverOverTourNamesActivation(){
        Actions builder = new Actions(driver);
        builder.moveToElement(tourNamesActivation).build().perform();
    }
}
