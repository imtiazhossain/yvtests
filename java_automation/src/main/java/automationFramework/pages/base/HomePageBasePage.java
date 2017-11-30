package automationFramework.pages.base;

import automationFramework.utils.Constants;
import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class HomePageBasePage extends BasePage {

    public HomePageBasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "open_experience selection screen_button")
    WebElement drpExperiences;

    public void navigateToExperience() {



        WebDriverUtils.getElementWhenClickeable(drpExperiences, Constants.TIMEOUT, driver).click();
    }
}