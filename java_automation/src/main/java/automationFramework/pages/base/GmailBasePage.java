package automationFramework.pages.base;

import automationFramework.handlers.YouvisitPageObjectsHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class GmailBasePage extends BasePage {

    protected static YouvisitPageObjectsHandler pageObjectsHandler;

    public GmailBasePage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver);
        GmailBasePage.pageObjectsHandler = handler;
    }

    public YouvisitPageObjectsHandler getPageObjectsHandler() {
        return pageObjectsHandler;
    }
    public void setPageObjectsHandler(YouvisitPageObjectsHandler pageObjectsHandler) {
        this.pageObjectsHandler = pageObjectsHandler;
    }

    public abstract By getPageLoadedLocator();
}
