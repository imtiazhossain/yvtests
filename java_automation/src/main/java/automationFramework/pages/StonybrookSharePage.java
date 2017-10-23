package automationFramework.pages;

import automationFramework.handlers.GmailPageObjectsHandler;
import automationFramework.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StonybrookSharePage extends BasePage {

    public StonybrookSharePage(WebDriver driver) {
        super(driver);
        if (!this.isLoaded()) {
            throw new IllegalStateException("This is not StonybrookHomePage");
        }
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"modalsContainer\"]/div/div/div/div/div[2]/input")
    WebElement nameInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modalsContainer\"]/div/div/div/div/div[3]/input")
    WebElement recipientInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modalsContainer\"]/div/div/div/div/div[4]/div/textarea[2]")
    WebElement messageArea;

    @FindBy(how = How.ID, using = "undefined_button")
    WebElement sendButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modalsContainer\"]/div/div/div/div/p[contains(text(), \"Your email was successfully sent!\")]")
    WebElement verificationMessage;

    public void navigate() {
        driver.get("http://qa.dev.youvisit.com/tour/stonybrook");
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Experience Stony Brook in Virtual Reality')]");
    }

    public void writeName(String name) {
        nameInput.sendKeys(name);
    }

    public void writeMessage(String message) {
        messageArea.sendKeys(message);
    }

    public void writeRecipient(String recipient) {
        recipientInput.sendKeys(recipient);
    }

    public GmailLoginPage clickSend() {
        sendButton.click();
        return GmailPageObjectsHandler.getInstance(driver).getGmailLoginPage();
    }

    public boolean isVerificationDisplayed() {
        return verificationMessage.isDisplayed();
    }
}
