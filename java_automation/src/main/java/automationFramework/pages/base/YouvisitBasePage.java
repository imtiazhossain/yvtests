package automationFramework.pages.base;

import automationFramework.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automationFramework.handlers.YouvisitPageObjectsHandler;
import automationFramework.pages.StonybrookHomePage;

public abstract class YouvisitBasePage extends BasePage {

    protected static YouvisitPageObjectsHandler pageObjectsHandler;

    public YouvisitBasePage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver);
        YouvisitBasePage.pageObjectsHandler = handler;
    }

    public YouvisitPageObjectsHandler getPageObjectsHandler() {
        return pageObjectsHandler;
    }
    public void setPageObjectsHandler(YouvisitPageObjectsHandler pageObjectsHandler) {
        this.pageObjectsHandler = pageObjectsHandler;
    }

    public abstract By getPageLoadedLocator();
}
