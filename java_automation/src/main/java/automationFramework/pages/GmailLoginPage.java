package automationFramework.pages;

import automationFramework.handlers.GmailPageObjectsHandler;
import automationFramework.pages.base.GmailBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailLoginPage extends GmailBasePage {
    public GmailLoginPage(WebDriver driver, GmailPageObjectsHandler handler) {
        super(driver, handler);
    }

    @FindBy(how = How.ID, using = "identifierId")
    WebElement emailInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"identifierNext\"]/content/span")
    WebElement nextEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"passwordNext\"]/content/span")
    WebElement nextPassword;

    //Boton pass //*[@id="password"]/div[1]/div/div[1]/input
    //Boton next //*[@id="passwordNext"]/div[2] //Devuelve inbox
    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Gmail')]");
    }
    public void navigate(){
        driver.get("https://mail.google.com");
    }
    public void writeEmail(String email){
        emailInput.sendKeys(email);
    }
    public void clickNextEmail(){
        nextEmail.click();
    }
    public void writePassword(String password){
        passwordInput.sendKeys(password);
    }
    public GmailInboxPage clickNextPassword(){
        wait.until(ExpectedConditions.elementToBeClickable(nextPassword));
        nextPassword.click();
        return pageObjectsHandler.getGmailInboxPage();
    }

}
