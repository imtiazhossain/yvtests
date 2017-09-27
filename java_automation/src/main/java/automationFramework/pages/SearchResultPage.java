package automationFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import automationFramework.pages.base.YouvisitBasePage;
import automationFramework.handlers.YouvisitPageObjectsHandler;

public class SearchResultPage extends YouvisitBasePage {

    @FindBy(how = How.CSS, using = "#content > div:nth-child(8)")
    WebElement rowItems;
    

    private Header header;

    public SearchResultPage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
        header = getPageObjectsHandler().getHeaderPage();
        if(!this.isLoaded()){
            throw new IllegalStateException("This is not HomePage");
        }
    }

    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Search - ')]");
    }
    public ProductPage clickFirstElement(){
        rowItems.findElement(By.cssSelector("a")).click();
        return getPageObjectsHandler().getProductPage();
    }
    
}
