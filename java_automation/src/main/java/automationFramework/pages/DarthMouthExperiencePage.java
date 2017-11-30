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

public class DarthMouthExperiencePage extends ExperienceBasePage {

    public DarthMouthExperiencePage(WebDriver driver) {
        super(driver);
        if (!this.isLoaded()) {
            throw new IllegalStateException("This is not DarthMouth Experience");
        }
    }

    @FindBy(how = How.XPATH, using = "//a[@title='Dartmouth Athletics']")
    WebElement expDarthMouthAthletics;

    public DarthMouthHomePage closeExperiencePage() {

        WebDriverUtils.waitSeconds(5);

        super.clickExitButton();

        return PageFactory.initElements(driver, DarthMouthHomePage.class);
    }

    public DarthMouthHomePage selectAthleticExperience() {

        WebDriverUtils.getElementWhenClickeable(expDarthMouthAthletics, Constants.TIMEOUT, driver).click();
        return PageFactory.initElements(driver, DarthMouthHomePage.class);
    }

    public void mouseOverExpDarthMouthAthletics() {
        WebDriverUtils.mouseoverElement(driver, expDarthMouthAthletics);
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//div[contains(text(),'Select an Experience')]");
    }
}