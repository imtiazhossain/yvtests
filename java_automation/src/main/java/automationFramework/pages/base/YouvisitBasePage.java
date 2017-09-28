package automationFramework.pages.base;

import automationFramework.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automationFramework.handlers.YouvisitPageObjectsHandler;
import automationFramework.pages.StonybrookHomePage;

public abstract class YouvisitBasePage extends BasePage {

    protected static YouvisitPageObjectsHandler pageObjectsHandler;
    protected Header header;

    public YouvisitBasePage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver);
        YouvisitBasePage.pageObjectsHandler = handler;
        header = getPageObjectsHandler().getHeaderPage();
    }

    public YouvisitPageObjectsHandler getPageObjectsHandler() {
        return pageObjectsHandler;
    }
    public void setPageObjectsHandler(YouvisitPageObjectsHandler pageObjectsHandler) {
        this.pageObjectsHandler = pageObjectsHandler;
    }

    public StonybrookHomePage goToHome(){
        return header.goToHome();
    }

//    public LoginPage goToLogin(){
//        return header.goToLogin();
//    }

    public SearchResultPage search(String item){
        return header.search(item);
    }

    public abstract By getPageLoadedLocator();
}
