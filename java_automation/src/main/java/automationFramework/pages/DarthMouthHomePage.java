package automationFramework.pages;

import automationFramework.pages.base.HomePageBasePage;
import automationFramework.utils.Constants;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class DarthMouthHomePage extends HomePageBasePage {

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Dartmouth Athletics')]")
    WebElement lblDarthMouthAthletics;

    @FindBy(how = How.XPATH, using = "//div[contains(@style,'opacity: 1')]/div[text()='DARTMOUTH ATHLETICS'] ")
    WebElement lblDarthMouthAthleticsLocation;

    @FindBy(how = How.XPATH, using = "//*[@id='stopsListItem1']/div[text()='Dartmouth Hall']")
    WebElement DartmoutHallScene;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Dartmouth College')]")
    WebElement lblDartmouthCollege;


    public boolean isDarthMouthAthleticsExpLoaded() {
        return WebDriverUtils.isElementPresent(driver, lblDarthMouthAthletics);

    }

    public DarthMouthHomePage(WebDriver driver) {
        super(driver);
        if (!this.isLoaded()) {
            throw new IllegalStateException("This is not DarthMouth HomePage");
        }
    }

    public DarthMouthExperiencePage navigateToExperiences() {

        navigateToExperience();

        return PageFactory.initElements(driver, DarthMouthExperiencePage.class);
    }

    public boolean verifyExperienceDrawerIsNotDisplayed() {

        return WebDriverUtils.isElementPresent(driver, By.xpath("//div[contains(text(),'Select an Experience')]"));
    }

    public boolean verifySceneLocationIsHighlightedAndDisplayed() {

        return WebDriverUtils.isElementPresent(driver, lblDarthMouthAthleticsLocation);
    }

    public void hoverLeftSide(int x, int y) {

        WebDriverUtils.waitSeconds(5);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.mouseMove(x, y);

        WebDriverUtils.waitSeconds(3);
    }

    public void hoverScene() {
        WebDriverUtils.mouseoverElement(driver, DartmoutHallScene);
        WebDriverUtils.waitSeconds(3);
    }


    public void selectDartmoutHallScene() {

        DartmoutHallScene.click();
        WebDriverUtils.waitSeconds(5);
    }

    public boolean wasDartmoutHallSceneSelected() {

        return lblDartmouthCollege.isDisplayed();
    }


    public void scrollToScene(String sceneName) {

       // WebDriverUtils.scrollToElement(driver, driver.findElement(By.xpath("//div[contains(text(),'" + sceneName + "')]")));


        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='stopsListItem9']")));

       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//*[@id='stopsListItem9']")));

       /* WebElement element = driver.findElement(By.xpath("//*[@id='stopsListItem9']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();*/

    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//*[@id='info_button']");
    }
}