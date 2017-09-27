package tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import automationFramework.handlers.YouvisitPageObjectsHandler;
import automationFramework.pages.Cart;
import automationFramework.pages.Header;
import automationFramework.pages.HomePage;

public class YouvisitBaseTest extends BaseTest {

    protected YouvisitPageObjectsHandler pageObjectsHandler;
    protected HomePage homePage;
    protected Header headerPage;
    protected Cart cart;

    @BeforeMethod
    public void initialize() {
        pageObjectsHandler = YouvisitPageObjectsHandler.getInstance(driver, eyes);
//        homePage = pageObjectsHandler.getHomePage();
//        headerPage = pageObjectsHandler.getHeaderPage();
//        cart = pageObjectsHandler.getCart();
    }

    @AfterMethod
    public void dispose() {
        YouvisitPageObjectsHandler.setInstanceNull();
    }
}
