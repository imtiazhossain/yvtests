package automationFramework.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automationFramework.handlers.YouvisitPageObjectsHandler;
import automationFramework.pages.Cart;
import automationFramework.pages.Header;
import automationFramework.pages.HomePage;
import automationFramework.pages.LoginPage;
import automationFramework.pages.SearchResultPage;

public abstract class YouvisitBasePage extends BasePage {

    protected static YouvisitPageObjectsHandler pageObjectsHandler;
    protected Header header;
    protected Cart cart;

    public YouvisitBasePage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver);
        YouvisitBasePage.pageObjectsHandler = handler;
        header = getPageObjectsHandler().getHeaderPage();
        cart = getPageObjectsHandler().getCart();
    }

    public YouvisitPageObjectsHandler getPageObjectsHandler() {
        return pageObjectsHandler;
    }
    public void setPageObjectsHandler(YouvisitPageObjectsHandler pageObjectsHandler) {
        this.pageObjectsHandler = pageObjectsHandler;
    }

    public HomePage goToHome(){
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
