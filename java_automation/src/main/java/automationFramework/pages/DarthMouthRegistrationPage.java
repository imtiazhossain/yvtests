package automationFramework.pages;

import automationFramework.pages.base.RegistrationBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DarthMouthRegistrationPage extends RegistrationBasePage {

    public DarthMouthRegistrationPage(WebDriver driver) {
        super(driver);
    }


    public DarthMouthExperiencePage closeRegistrattionModal(){

        clickExitButton();

        return PageFactory.initElements(driver, DarthMouthExperiencePage.class);
    }

}
