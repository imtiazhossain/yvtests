package tests.single;

import automationFramework.pages.SwarovskiPage;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

public class PaymentsTests extends TestBase {

    private SwarovskiPage swarovskiPage;

    @Severity(SeverityLevel.NORMAL)
    @Test(groups = { "SMOKE"})
    public void submitting() throws Exception {
//        swarovskiPage = pageObjectsHandler.getSwarovskiPage();
//        swarovskiPage.getPageLoadedLocator();
//        swarovskiPage.clickSkipIntro();
//        swarovskiPage.clickApplication();
//        swarovskiPage.clickHotspot();
//        swarovskiPage.clickBuy();
//        swarovskiPage.clickCheckout();
//        swarovskiPage.inputName("QA Tester");
//        swarovskiPage.inputAddress("Juan's House");
//        swarovskiPage.inputZipcode("10001");
//        swarovskiPage.inputEmail("testingyv@gmail.com");
//        swarovskiPage.clickContinue();
//        swarovskiPage.inputCardName("QA Tester");
//        swarovskiPage.inputCardNumber("4242424242424242");
//        swarovskiPage.inputExpDate("1030");
//        swarovskiPage.inputCVC("123");
//        swarovskiPage.clickSubmit();
//        swarovskiPage.clickPlaceOrder();
//        swarovskiPage.clickContinueExp();
    }
}

