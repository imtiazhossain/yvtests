package automationFramework.pages;

import automationFramework.handlers.GmailPageObjectsHandler;
import automationFramework.handlers.YouvisitPageObjectsHandler;
import automationFramework.pages.base.YouvisitBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

public class StonybrookSharePage extends YouvisitBasePage {

    public StonybrookSharePage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
        if(!this.isLoaded()){
            throw new IllegalStateException("This is not StonybrookHomePage");
        }
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"modalsContainer\"]/div/div/div/div/div[2]/input")
    WebElement nameInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modalsContainer\"]/div/div/div/div/div[3]/input")
    WebElement recipientInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modalsContainer\"]/div/div/div/div/div[4]/div/textarea")
    WebElement messageArea;

    @FindBy(how = How.ID, using = "undefined_button")
    WebElement sendButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modalsContainer\"]/div/div/div/div/p[contains(text(), \"Your email was successfully sent!\")]")
    WebElement verificationMessage;

    //*[@id="undefined-undefined-Message-26165"]
    //*[@id="modalsContainer"]/div/div/div/div/div[4]/div/textarea

    public void navigate(){
        driver.get("http://qa.dev.youvisit.com/tour/stonybrook");
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Experience Stony Brook in Virtual Reality')]");
    }
    public void writeName(String name){
        nameInput.sendKeys(name);
    }
    public void writeMessage(String message){
        messageArea.sendKeys(message);
    }
    public void writeRecipient(String recipient){
        recipientInput.sendKeys(recipient);
    }
    public GmailLoginPage clickSend(){
        sendButton.click();
        return GmailPageObjectsHandler.getInstance(driver,eyes).getGmailLoginPage();
    }

    public boolean isVerificationDisplayed() {
        return verificationMessage.isDisplayed();
    }
}
