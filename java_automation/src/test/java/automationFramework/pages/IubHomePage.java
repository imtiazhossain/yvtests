package automationFramework.pages;

import automationFramework.pages.base.HomePageBasePage;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class IubHomePage extends HomePageBasePage {

    public IubHomePage(WebDriver driver) {
        super(driver);
        if (!this.isLoaded()) {
            throw new IllegalStateException("This is not IUB HomePage");
        }
    }



    public IubExperiencePage navigateToExperiences(){

        navigateToExperience();

        return PageFactory.initElements(driver, IubExperiencePage.class);
    }

    public boolean verifyExperienceDrawerIsNotDisplayed(){

        return WebDriverUtils.isElementPresent(driver, By.xpath("//div[contains(text(),'Select an Experience')]"));
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//*[@id='info_button']");
    }


}