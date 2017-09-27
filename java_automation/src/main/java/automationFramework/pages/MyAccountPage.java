/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automationFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automationFramework.pages.base.YouvisitBasePage;
import automationFramework.handlers.YouvisitPageObjectsHandler;

/**
 *
 * @author JSoarez
 */
public class MyAccountPage extends YouvisitBasePage {
       
    public MyAccountPage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
        if(!this.isLoaded()){
            throw new IllegalStateException("This is not My Account Page");
        }
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'My Account')]");
    }
}
