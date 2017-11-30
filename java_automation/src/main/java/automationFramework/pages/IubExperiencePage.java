package automationFramework.pages;

import automationFramework.pages.base.ExperienceBasePage;
import automationFramework.utils.Constants;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IubExperiencePage extends ExperienceBasePage {

    public IubExperiencePage(WebDriver driver) {
        super(driver);
        if (!this.isLoaded()) {
            throw new IllegalStateException("This is not IUB Experience");
        }
    }

    @FindBy(how = How.XPATH, using = "//a[@title='Bloomington Campus Tour']")
    WebElement expCampusTour;

    @FindBy(how = How.XPATH, using = "//a[@title='IU Athletics 360 Experience']")
    WebElement exp360Tour;

    public IubHomePage closeExperiencePage() {

        super.clickExitButton();
        clickSkipIntro();
        WebDriverUtils.waitSeconds(Constants.TIMEOUT);
        return PageFactory.initElements(driver, IubHomePage.class);
    }

    public IubHomePage selectCAmpusExperience() {

        WebDriverUtils.getElementWhenClickeable(expCampusTour, Constants.TIMEOUT, driver).click();
        return PageFactory.initElements(driver, IubHomePage.class);
    }

    public boolean verifyScroll() {

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", exp360Tour);

        return WebDriverUtils.getElementWhenClickeable(exp360Tour, Constants.SHORT_TIMEOUT, driver).isDisplayed();
    }


    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//div[contains(text(),'Select an Experience')]");
    }
}