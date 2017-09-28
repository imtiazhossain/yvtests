package tests.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import automationFramework.handlers.YouvisitPageObjectsHandler;
import automationFramework.pages.Header;
import automationFramework.pages.StonybrookHomePage;

public class YouvisitBaseTest extends BaseTest {

    protected YouvisitPageObjectsHandler pageObjectsHandler;
    protected StonybrookHomePage stonybrookHomePage;
    protected Header headerPage;

    @BeforeMethod
    public void initialize() {
        pageObjectsHandler = YouvisitPageObjectsHandler.getInstance(driver, eyes);
//        stonybrookHomePage = pageObjectsHandler.getStonybrookHomePage();
//        headerPage = pageObjectsHandler.getHeaderPage();
//        cart = pageObjectsHandler.getCart();
    }

    @AfterMethod
    public void dispose() {
        YouvisitPageObjectsHandler.setInstanceNull();
    }
}
