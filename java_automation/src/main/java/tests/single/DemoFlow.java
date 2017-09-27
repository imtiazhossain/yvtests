/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.single;
import tests.base.YouvisitBaseTest;
import automationFramework.pages.*;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static org.testng.Assert.assertTrue;

/**
 *
 * @author JSoarez
 */
public class DemoFlow extends YouvisitBaseTest {
      private SearchResultPage searchResultPage;
      private LoginPage loginpage;
      private ProductPage productpage;
      private CartPage cartpage;
      private Cart cart;

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testFlowDemo() throws Exception {
//        loginpage = headerPage.goToLogin();
        loginpage.completeLoginData("santiago.cabrera@abstracta.com.uy", "Santiago9");
        loginpage.clickOnLogin();
        searchResultPage = loginpage.search("nikon");
        productpage = searchResultPage.clickFirstElement();
        productpage.changeQuantity("5");
        productpage.clickAddToCart();
        assertTrue(productpage.assertAddedToCart());
        cartpage = headerPage.showCart();
        cartpage.clickDeleteItems();
        assertTrue(cartpage.assertEmptyCart());
    }
}
