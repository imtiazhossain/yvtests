/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automationFramework.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import automationFramework.pages.base.YouvisitBasePage;
import automationFramework.handlers.YouvisitPageObjectsHandler;

/**
 *
 * @author JSoarez
 */
public class CartPage extends YouvisitBasePage {

    @FindBy(how = How.CSS, using = "#content > form > div > table > tbody > tr > td:nth-child(4) > div > input")
    WebElement quantityTxt;
    
    @FindBy(how = How.CSS, using = "#content > form > div > table > tbody > tr > td:nth-child(4) > div > span > button.btn.btn-danger")
    WebElement btnDelete;
    
    @FindBy(how = How.CSS, using = "#content")
    WebElement content;
   
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/a")
    WebElement continuebtn;
    
    public CartPage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
        if(!this.isLoaded()){
            throw new IllegalStateException("This is not CartPage");
        }
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Shopping Cart')]");
    }
    
    public boolean assertQuantity(String quantity){
        System.err.println(quantityTxt.getAttribute("value"));
        return quantityTxt.getAttribute("value").equals(quantity);
    }
    
    public void clickDeleteItems() throws InterruptedException{
        btnDelete.click();
        Thread.sleep(1000);
    }
    
    public boolean assertEmptyCart(){
        driver.navigate().refresh();
        for(WebElement e :  content.findElements(By.tagName("p"))){
            System.err.println(e.getText());
            if (e.getText().equals("Your shopping cart is empty!")){
                return true;
            }
        }
       return false;
    }
}