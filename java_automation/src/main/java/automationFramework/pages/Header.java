package automationFramework.pages;

import automationFramework.utils.datatypes.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import automationFramework.pages.base.YouvisitBaseElement;
import automationFramework.handlers.YouvisitPageObjectsHandler;

public class Header extends YouvisitBaseElement {

    @FindBy(how = How.NAME, using = "search")
    WebElement searchText;

    @FindBy(how = How.CSS, using = "#logo a")
    WebElement logo;

    @FindBy(how = How.CSS, using = "#search button.btn")
    WebElement searchButton;

    @FindBy(how = How.CSS, using = "#top-links > ul > li:nth-child(4) > a > span")
    WebElement cartButton;
    
    @FindBy(how = How.CSS, using = "#top-links > ul > li.dropdown > a")
    WebElement myAccountbtn;
    
    @FindBy(how = How.CSS, using = "#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a")
    WebElement loginBtn;

    public Header(WebDriver driver, YouvisitPageObjectsHandler instance) {
        super(driver, instance);
    }

    public HomePage goToHome(){
        logo.click();
        addWait(Wait.SHORT_WAIT);
        return getPageObjectsHandler().getHomePage();
    }

    public SearchResultPage search(String product){
        sendText(searchText, product);
        searchButton.click();
        addWait(Wait.SHORT_WAIT);
        return getPageObjectsHandler().getSearchResultPage();
    }

    public CartPage showCart(){
        cartButton.click();
        return getPageObjectsHandler().getCartPage();
    }
}
