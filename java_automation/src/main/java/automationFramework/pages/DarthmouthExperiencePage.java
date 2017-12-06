package automationFramework.pages;

import automationFramework.pages.base.ExperienceBasePage;
import automationFramework.utils.Constants;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DarthmouthExperiencePage extends ExperienceBasePage {

    @FindBy(how = How.XPATH, using = "//a[@title='Dartmouth Athletics']")
    WebElement expDarthMouthAthletics;

    @FindBy(how = How.XPATH, using = "//text[text()='Dartmouth College']")
    WebElement expDartmouthCollege;

    public DarthmouthExperiencePage(WebDriver driver) {
        super(driver);
        if (!this.isLoaded()) {
            throw new IllegalStateException("This is not DarthMouth Experience");
        }
    }

    public DarthmouthHomePage closeExperiencePage() {

        WebDriverUtils.waitSeconds(5);
        super.clickExitButton();
        WebDriverUtils.waitSeconds(5);

        return PageFactory.initElements(driver, DarthmouthHomePage.class);
    }

    public DarthmouthHomePage selectAthleticExperience() {

        WebDriverUtils.getElementWhenClickeable(expDarthMouthAthletics, Constants.TIMEOUT, driver).click();
        return PageFactory.initElements(driver, DarthmouthHomePage.class);
    }

    public void mouseOverExpDarthMouthAthletics() {
        WebDriverUtils.mouseoverElement(driver, expDarthMouthAthletics);
    }

    public DarthmouthHomePage selectExpDartmouthCollege() {

        WebDriverUtils.getElementWhenClickeable(expDartmouthCollege, Constants.TIMEOUT, driver).click();

        return PageFactory.initElements(driver, DarthmouthHomePage.class);
    }


    @Override

    public By getPageLoadedLocator() {
        return By.xpath("//div[contains(text(),'Select an Experience')]");
    }
}