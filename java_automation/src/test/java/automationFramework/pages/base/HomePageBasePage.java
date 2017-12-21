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

    @FindBy(how = How.ID, using = "navigation_F_R_button")
    WebElement navigateFontRightbtn;

    @FindBy(how = How.ID, using = "navigation_F_button")
    WebElement navigateFrontbtn;

    @FindBy(how = How.ID, using = "navigation_B_button")
    WebElement navigateBackbtn;


    public void navigateFrontRightButton() {

        WebDriverUtils.getElementWhenClickeable(navigateFontRightbtn, Constants.TIMEOUT, driver).click();
        WebDriverUtils.waitSeconds(5);
    }

    public void navigateFrontButton() {

        WebDriverUtils.waitSeconds(5);
        WebDriverUtils.getElementWhenClickeable(navigateFrontbtn, Constants.TIMEOUT, driver).click();
        WebDriverUtils.waitSeconds(5);
    }

    public void navigateBackButton() {

        WebDriverUtils.waitSeconds(5);
        WebDriverUtils.getElementWhenClickeable(navigateBackbtn, Constants.TIMEOUT, driver).click();
        WebDriverUtils.waitSeconds(5);
    }

    public void navigateToExperience() {

        WebDriverUtils.getElementWhenClickeable(drpExperiences, Constants.TIMEOUT, driver).click();
    }
}