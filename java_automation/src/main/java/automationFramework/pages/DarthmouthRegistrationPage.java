package automationFramework.pages;

import automationFramework.pages.base.RegistrationBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DarthmouthRegistrationPage extends RegistrationBasePage {

    public DarthmouthRegistrationPage(WebDriver driver) {
        super(driver);
    }


    public DarthmouthExperiencePage closeRegistrationModal(){

        clickExitButton();

        return PageFactory.initElements(driver, DarthmouthExperiencePage.class);
    }

}
