package automationFramework.pages;

import automationFramework.pages.base.RegistrationBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class IubRegistrationPage extends RegistrationBasePage {

    public IubRegistrationPage(WebDriver driver) {
        super(driver);
    }


    public IubExperiencePage closeRegistrationModal(){

        clickExitButton();

        return PageFactory.initElements(driver, IubExperiencePage.class);
    }

}
