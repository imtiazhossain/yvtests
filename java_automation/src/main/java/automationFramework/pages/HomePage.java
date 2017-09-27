package automationFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automationFramework.pages.base.YouvisitBasePage;
import automationFramework.handlers.YouvisitPageObjectsHandler;

public class HomePage extends YouvisitBasePage {

    public HomePage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
        if(!this.isLoaded()){
            throw new IllegalStateException("This is not HomePage");
        }
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Your Store')]");
    }
}
