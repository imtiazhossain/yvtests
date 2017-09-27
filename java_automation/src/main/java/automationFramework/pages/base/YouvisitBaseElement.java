package automationFramework.pages.base;

import org.openqa.selenium.WebDriver;
import automationFramework.handlers.YouvisitPageObjectsHandler;

public class YouvisitBaseElement extends BaseElement{

    protected static YouvisitPageObjectsHandler pageObjectsHandler;

    public YouvisitBaseElement(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver);
        pageObjectsHandler = handler;
    }

    public YouvisitPageObjectsHandler getPageObjectsHandler() {
        return pageObjectsHandler;
    }
}
