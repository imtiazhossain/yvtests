package automationFramework.pages;

import automationFramework.utils.datatypes.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import automationFramework.pages.base.YouvisitBasePage;
import automationFramework.handlers.YouvisitPageObjectsHandler;

public class ProductPage extends YouvisitBasePage {

    @FindBy(how = How.CSS, using = "#input-quantity")
    WebElement quantityTxtBox;
    
    @FindBy(how = How.CSS, using = "#button-cart")
    WebElement addToCartBtn;
    
    @FindBy(how = How.CSS, using = "body > div:nth-child(4) > div.alert.alert-success")
    WebElement addedLbl;
    
    public ProductPage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
        if(!this.isLoaded()){
            throw new IllegalStateException("This is not ProductPage");
        }
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'')]");
    }
    public void changeQuantity(String quantity){
        quantityTxtBox.clear();
        quantityTxtBox.sendKeys(quantity);
    }
    public void clickAddToCart(){
        addToCartBtn.click();
    }
    public boolean assertAddedToCart(){
        addWait(Wait.SHORT_WAIT);
        return addedLbl.isDisplayed();
    }
}
