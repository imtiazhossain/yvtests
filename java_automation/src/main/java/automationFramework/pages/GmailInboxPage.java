package automationFramework.pages;

import automationFramework.handlers.GmailPageObjectsHandler;
import automationFramework.pages.base.GmailBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailInboxPage extends GmailBasePage {
    public GmailInboxPage(WebDriver driver, GmailPageObjectsHandler handler) {
        super(driver, handler);
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Inbox - testingyouvisit@gmail.com - Gmail')]");
    }
    //
}
