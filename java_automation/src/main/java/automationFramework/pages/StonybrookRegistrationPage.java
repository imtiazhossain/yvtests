package automationFramework.pages;

import automationFramework.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StonybrookRegistrationPage extends BasePage {
    public StonybrookRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "registration-visitortype")
    WebElement imA;

    @FindBy(how = How.XPATH, using = "//*[@item-value=\"prospective_student\"]") //item-value="prospective_student"
            WebElement optionProspectiveStudent;

    @FindBy(how = How.XPATH, using = "//*[@item-value=\"hs_grad\"]") //item-value="hs_grad"
            WebElement optionHighSchoolGraduate;

    @FindBy(how = How.XPATH, using = "//*[@item-value=\"alumni\"]") //item-value="hs_grad"
            WebElement optionAlumni;

    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-firstname\"]/div[1]/input")
    WebElement firstName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-lastname\"]/div[1]/input")
    WebElement lastName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-email\"]/div[1]/input")
    WebElement email;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-gender\"]/div[1]/select")
    WebElement genderSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-school\"]/div[1]/input")
    WebElement highschool;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-id-1\"]/li/a[1]")
    WebElement firstSchool;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-enrollyear\"]/div[1]/select")
    WebElement enrollmentYearSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-major\"]/div[1]/select")
    WebElement majorSelect;
    @FindBy(how = How.XPATH, using = "//*[@title='Date of Birth *']/input")
    WebElement dateOfBirth;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")
    WebElement birthYearSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")
    WebElement birthMonthSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/table/tbody")
    WebElement birthAllDays;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-phone\"]/div[1]/input")
    WebElement phone;
    @FindBy(how = How.ID, using = "country")
    WebElement countrySelect;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), \"Thanks for your submission!\")]")
    WebElement confirmationMessage;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), \"DONE\")]")
    WebElement confirmationDone;
    @FindBy(how = How.XPATH, using = "//*[@alt=\"exit\"]")
    WebElement exitButton;
    @FindBy(how = How.CLASS_NAME, using = "ui-datepicker-year")
    WebElement yearSelect;
    @FindBy(how = How.CLASS_NAME, using = "ui-datepicker-month")
    WebElement monthSelect;
    @FindBy(how = How.CLASS_NAME, using = "ui-state-default")
    List<WebElement> datePicker;

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Experience Stony Brook in Virtual Reality')]");
    }

    public void clickImA() {
        wait.until(ExpectedConditions.elementToBeClickable(imA));
        imA.click();
    }

    public void clickOptionProspectiveStudent() {
        wait.until(ExpectedConditions.elementToBeClickable(optionProspectiveStudent));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        optionProspectiveStudent.click();
    }

    public void clickOptionHighSchoolGraduate() {
        wait.until(ExpectedConditions.elementToBeClickable(optionHighSchoolGraduate));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        optionHighSchoolGraduate.click();
    }

    public void clickOptionAlumni() {
        wait.until(ExpectedConditions.elementToBeClickable(optionAlumni));
        optionAlumni.click();
    }

    public void writeCompleteName(String first, String last) {
        firstName.sendKeys(first);
        lastName.sendKeys(last);
    }

    public void writeEmail(String email) {
        this.email.sendKeys(email);
    }

    public void selectGender(String gender) {
        genderSelect.click();
        genderSelect.findElement(By.xpath("//*[contains(text(), \"" + gender + "\")]")).click();
    }

    public void selectEnrollmentYear(String year) {
        enrollmentYearSelect.click();
        enrollmentYearSelect.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        enrollmentYearSelect.findElement(By.xpath("//*[contains(text(), \"" + year + "\")]")).click();
    }

    public void writeAndSelectCurrentSchool(String school) {
        highschool.sendKeys(school);
        firstSchool.click();
    }

    public void selectMajor(String major) {
        majorSelect.click();
        majorSelect.findElement(By.xpath("//*[contains(text(), \"" + major + "\")]")).click();
    }

    public void writeDateOfBirth(String date) {
        dateOfBirth.sendKeys(date);
        dateOfBirth.sendKeys(Keys.RETURN);
    }

    public void selectDateOfBirth(String year, String month, String day) {
        dateOfBirth.click();
        Select yearAge = new Select(yearSelect);
        yearAge.selectByValue(year);
        Select monthAge = new Select(monthSelect);
        monthAge.selectByVisibleText(month);
        for (WebElement element : datePicker) {
            if (element.getText().contentEquals(day)) {
                element.click();
                break;
            }
        }
    }

    public void writePhone(String phone) {
        this.phone.sendKeys(phone);
    }

    public void selectCountry(String country) {
        // countrySelect.click();
        //countrySelect.findElement(By.xpath("//*[contains(text(), '" + country + "')]")).click();
        Select dropdown = new Select(countrySelect);
        dropdown.selectByVisibleText(country);
        phone.click();

    }

    public void submitForm() {
        email.submit();
    }

    public boolean getConfirmationMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.isDisplayed();
    }

    public StonybrookHomePage clickDoneConfirmation() {
        confirmationDone.click();
        return pageObjectsHandler.getStonybrookHomePage();
    }

    public StonybrookHomePage clickExitButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(exitButton));
        exitButton.click();
        Thread.sleep(3000);
        return pageObjectsHandler.getStonybrookHomePage();
    }


    public boolean assertPopupIsShown() {
        if (exitButton.isDisplayed()) {
            return true;
        }
        return false;
    }

    public StonybrookExperiencePage closeRegistrattionModal(){

        clickExitButton();

        return PageFactory.initElements(driver, StonybrookExperiencePage.class);
    }

    public StonybrookHomePage closeRegistration(){

        clickExitButton();

        return PageFactory.initElements(driver, StonybrookHomePage.class);
    }
}
