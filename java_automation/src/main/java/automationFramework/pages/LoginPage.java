package automationFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import automationFramework.pages.base.YouvisitBasePage;
import automationFramework.handlers.YouvisitPageObjectsHandler;

public class LoginPage extends YouvisitBasePage {

    @FindBy(how = How.CSS, using = "#input-email")
    WebElement emailText;

    @FindBy(how = How.CSS, using = "#input-password")
    WebElement passwordText;
    
    @FindBy(how = How.CSS, using = "#content > div > div:nth-child(2) > div > form > input")
    WebElement loginBtn;
    
    public LoginPage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
        if(!this.isLoaded()){
            throw new IllegalStateException("This is not Login Page");
        }
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Account Login')]");
    }
    
    public void completeLoginData(String xEmail, String xPassword){
        emailText.sendKeys(xEmail);
        passwordText.sendKeys(xPassword);
    }
    
    public MyAccountPage clickOnLogin(){
        loginBtn.click();
        return getPageObjectsHandler().getMyAccountPage();
    }
}
