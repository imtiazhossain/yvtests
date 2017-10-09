package automationFramework.pages;

import automationFramework.handlers.GmailPageObjectsHandler;
import automationFramework.pages.base.GmailBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GmailInboxPage extends GmailBasePage {
    public GmailInboxPage(WebDriver driver, GmailPageObjectsHandler handler) {
        super(driver, handler);
    }

    @FindBy(how = How.CSS, using = "#\\3a 37 > span")
    WebElement tableMails;

    @FindBy(how = How.CLASS_NAME, using = "gs")
    List<WebElement> mailBodyDiv;

    @FindBy(how = How.XPATH, using = "//*[@id=\":5\"]/div[2]/div[1]/div/div[2]/div[3]/div/div")
    WebElement deleteMailButton;

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Inbox - testingyouvisit@gmail.com - Gmail')]");
    }

    public boolean checkIfFirstMailIsFromYouVisit() {
        return tableMails.getAttribute("email").contentEquals("noreply@youvisit.com");
    }

    public void clickOnYouVisitMail() {
        tableMails.click();
    }

    public boolean isMessageTheSame(String description) {
        for (WebElement e : mailBodyDiv) {
            if (e.getText().contains(description)) {
                return true;
            }
        }
        return false;
    }

    public void deleteMail() {
        deleteMailButton.click();
    }
}
