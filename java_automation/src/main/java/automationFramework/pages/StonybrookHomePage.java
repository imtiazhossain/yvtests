package automationFramework.pages;

import automationFramework.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class StonybrookHomePage extends BasePage {

    public StonybrookHomePage(WebDriver driver) {
        super(driver);
        if (!this.isLoaded()) {
            throw new IllegalStateException("This is not StonybrookHomePage");
        }
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"navigation_F_button\"]")
    WebElement navigateForwardButton;

    @FindBy(how = How.CLASS_NAME, using = "actionButtons")
    WebElement actionButtonsDiv;

    @FindBy(how = How.ID, using = "action_register")
    WebElement registerNowButton;

    @FindBy(how = How.ID, using = "action_action2")
    WebElement scheduleVisitButton;

    @FindBy(how = How.ID, using = "action_action3")
    WebElement applyOnlineButton;

    @FindBy(how = How.CSS, using = ".activationZone")
    WebElement tourNamesActivation;

    @FindBy(how = How.CSS, using = ".stopslist")
    WebElement stopsList;

    @FindBy(how = How.XPATH, using = "//*[@id=\"avatar\"]")
    WebElement avatar;

    @FindBy(how = How.CSS, using = "#vr_button > div > svg")
    WebElement vrButton;

    @FindBy(how = How.ID, using = "close_button")
    WebElement vrClosePanel;

    @FindBy(how = How.ID, using = "share_desktop_button")
    WebElement shareDesktopButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"share_menu\"]/div[2]/div[1]/div")
    WebElement shareEmailButton;

    @FindBy(how = How.ID, using = "campusmap")
    WebElement miniMapDiv;

    //@FindBy(how = How.CSS, using = "#mapFull_button")
    //WebElement expandMapButton;

    @FindBy(how = How.ID, using = "mapFull_button")
    WebElement expandMapButton;

    @FindBy(how = How.ID, using = "campusmap")
    WebElement campusMapDiv;

    @FindBy(how = How.ID, using = "scene-description")
    WebElement sceneDescriptionDiv;

    @FindBy(how = How.ID, using = "stop_211")
    WebElement markerButton;

    public void navigate() {
        driver.get("http://qa.dev.youvisit.com/tour/stonybrook");
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Experience Stony Brook in Virtual Reality')]");
    }

    public boolean navigateForwardButtonIsDisplayed() {
        return navigateForwardButton.isDisplayed();
    }

    public void clickNavigateForward() {
        navigateForwardButton.click();
    }

    public boolean checkIfTopButtonsArePresent() {
        Point buttonsDiv = actionButtonsDiv.getLocation();
        int ycoord = buttonsDiv.getY();
        int xcoord = buttonsDiv.getX();
        System.out.println(ycoord);
        System.out.println(xcoord);
        if (ycoord != 0) {
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
        if (driver.getCurrentUrl().contentEquals("http://www.youvisit.com/tour/stonybrook")) {
            return false;
        }
        return true;
    }

    public void clickOnSecondButton() {
        scheduleVisitButton.click();
    }

    public void changeFocusToLastTab() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }

    public void closeLastTab() {
        driver.close();
        changeFocusToLastTab();
    }

    public void hoverOverTourNamesActivation() {
        Actions builder = new Actions(driver);
        builder.moveToElement(tourNamesActivation).build().perform();
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].onmouseover()", tourNamesActivation);
    }

    public boolean stopsListIsDisplayed() {
        return stopsList.isDisplayed();
    }

    public void clickOnThirdButton() {
        applyOnlineButton.click();
    }

    public boolean avatarIsDisplayed() {
        return avatar.isDisplayed();
    }

    public void clickOnVRButton() {
        vrButton.click();
    }

    public boolean checkIfVRpanelIsPresent() throws InterruptedException {
        Thread.sleep(2000);
        try {
            if (vrClosePanel.isDisplayed()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void closeVRpanel() {
        vrClosePanel.click();
    }

    public void clickShareDesktopButton() {

        wait.until(ExpectedConditions.elementToBeClickable(shareDesktopButton));
        shareDesktopButton.click();
    }

    public StonybrookSharePage clickShareEmail() {
        wait.until(ExpectedConditions.visibilityOf(shareEmailButton));
        shareEmailButton.click();
        return pageObjectsHandler.getStonybrookSharePage();
    }

    public boolean checkMiniMapIsPresent() {
        return miniMapDiv.isDisplayed();
    }

    public int returnMapHeight() {
        wait.until(ExpectedConditions.visibilityOf(miniMapDiv));
        return miniMapDiv.getSize().getHeight();
    }

    public void hoverOnMiniMap() {
        Actions actions = new Actions(driver);
        actions.moveToElement(miniMapDiv).build().perform();

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].onmouseover()", miniMapDiv);
    }

    public int returnMapWidth() {
        return miniMapDiv.getSize().getWidth();
    }

    public void clickOnExpandMap() {
        wait.until(ExpectedConditions.elementToBeClickable(expandMapButton));
        expandMapButton.click();
    }

    public boolean checkIfCampusMapIsPresent() {
        return campusMapDiv.isDisplayed();
    }

    public String getSceneDescriptionText() {
        return sceneDescriptionDiv.getText();
    }

    public void clickMarkOnMap() {
        markerButton.click();
    }

}
