package automationFramework.pages.base;

import automationFramework.handlers.GmailPageObjectsHandler;
import automationFramework.handlers.YouvisitPageObjectsHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class GmailBasePage extends BasePage {

    protected static GmailPageObjectsHandler pageObjectsHandler;

    public GmailBasePage(WebDriver driver, GmailPageObjectsHandler handler) {
        super(driver);
        GmailBasePage.pageObjectsHandler = handler;
    }

    public GmailPageObjectsHandler getPageObjectsHandler() {
        return pageObjectsHandler;
    }
    public void setPageObjectsHandler(GmailPageObjectsHandler pageObjectsHandler) {
        GmailBasePage.pageObjectsHandler = pageObjectsHandler;
    }

    public abstract By getPageLoadedLocator();
}
