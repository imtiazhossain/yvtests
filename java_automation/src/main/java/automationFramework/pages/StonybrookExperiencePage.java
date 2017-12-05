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

public class StonybrookExperiencePage extends ExperienceBasePage {

    public StonybrookExperiencePage(WebDriver driver) {
        super(driver);
        if (!this.isLoaded()) {
            throw new IllegalStateException("This is not StonyBrook Experience");
        }
    }

    public StonybrookHomePage closeExperiencePage() {

        WebDriverUtils.waitSeconds(5);
        super.clickExitButton();
        WebDriverUtils.waitSeconds(5);

        return PageFactory.initElements(driver, StonybrookHomePage.class);
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//div[contains(text(),'Select an Experience')]");
    }
}