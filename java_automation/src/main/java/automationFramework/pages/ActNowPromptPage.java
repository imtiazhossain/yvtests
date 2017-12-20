package automationFramework.pages;

import automationFramework.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActNowPromptPage extends BasePage {

    public ActNowPromptPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'ctaButtonArea')]")
    public WebElement actNowPrompt;

    @FindBy(how = How.XPATH, using = "//a//span[contains(text(),'Register Now')]")
    WebElement registerNowBtn;

    @FindBy(how = How.XPATH, using = "//a//span[contains(text(),'Schedule Visit')]")
    WebElement scheduleVisitBtn;

    @FindBy(how = How.XPATH, using = "//a//span[contains(text(),'Apply Online')]")
    WebElement applyOnlineBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='modalsContainer']//img[contains(@class,'closeButton')]")
    WebElement closeButton;

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//div[contains(@class,'ctaButtonArea')]");
    }

    public boolean isActNowPromptDisplayed() {
        return actNowPrompt.isDisplayed();
    }

    public boolean isRegisterNowButtonDisplayed() {
        return registerNowBtn.isDisplayed();
    }

    public boolean isScheduleButtonVisitDisplayed() {

        return scheduleVisitBtn.isDisplayed();
    }

    public boolean isApplyOnlineButtonDisplayed() {

        return applyOnlineBtn.isDisplayed();
    }

    public boolean isCloseButtonDisplayed() {

        return closeButton.isDisplayed();
    }
}