package automationFramework.pages.base;

import automationFramework.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class ExperienceBasePage extends BasePage {
    public ExperienceBasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "close_button")
    WebElement closeBtn;

    @FindBy(how = How.ID, using = "skip_intro")
    WebElement SkipIntro;

    public void clickExitButton() {
        wait.until(ExpectedConditions.visibilityOf(closeBtn));

        if (WebDriverUtils.isElementPresent(driver, closeBtn)) {
            closeBtn.click();
        }
    }

    public void clickSkipIntro() {
        wait.until(ExpectedConditions.visibilityOf(SkipIntro));
        SkipIntro.click();
    }
}
