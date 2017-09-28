package automationFramework.pages;

import automationFramework.handlers.YouvisitPageObjectsHandler;
import automationFramework.pages.base.YouvisitBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StonybrookRegistrationPage extends YouvisitBasePage {
    public StonybrookRegistrationPage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
    }

    @FindBy(how = How.XPATH, using = "//*[@title=\"I am a *\"]")
    WebElement imA;

    @FindBy(how = How.XPATH, using = "//*[@item-value=\"prospective_student\"]") //item-value="prospective_student"
    WebElement optionProspectiveStudent;

    @FindBy(how = How.XPATH, using = "//*[@item-value=\"hs_grad\"]") //item-value="hs_grad"
    WebElement optionHighSchoolGraduate;

    //alumni
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
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-enrollyear\"]/div[1]/select")
    WebElement enrollmentYearSelect;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-major\"]/div[1]/select")
    WebElement majorSelect;
    @FindBy(how = How.XPATH, using = "//*[@title=\"Date of Birth *\"]/input")
    WebElement dateOfBirth;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-phone\"]/div[1]/input")
    WebElement phone;
    @FindBy(how = How.XPATH, using = "//*[@id=\"registration-country\"]/div[1]/select")
    WebElement countrySelect;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), \"Thanks for your submission!\")]")
    WebElement confirmationMessage;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), \"DONE\")]")
    WebElement confirmationDone;
    @FindBy(how = How.XPATH, using = "//*[@alt=\"exit\"]")
    WebElement exitButton;

    public void navigate(){
        driver.get("http://qa.dev.youvisit.com/tour/stonybrook");
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Experience Stony Brook in Virtual Reality')]");
    }

    public void clickImA(){
        wait.until(ExpectedConditions.elementToBeClickable(imA));
        imA.click();
    }
    public void clickOptionProspectiveStudent(){
        wait.until(ExpectedConditions.elementToBeClickable(optionProspectiveStudent));
        optionProspectiveStudent.click();
    }
    public void clickOptionHighSchoolGraduate(){
        wait.until(ExpectedConditions.elementToBeClickable(optionHighSchoolGraduate));
        optionHighSchoolGraduate.click();
    }
    public void clickOptionAlumni(){
        wait.until(ExpectedConditions.elementToBeClickable(optionAlumni));
        optionAlumni.click();
    }
    public void writeCompleteName(String first, String last){
        firstName.sendKeys(first);
        lastName.sendKeys(last);
    }
    public void writeEmail(String email){
        this.email.sendKeys(email);
    }
    public void selectGender(String gender){
        genderSelect.click();
        genderSelect.findElement(By.xpath("//*[contains(text(), \"" + gender + "\")]")).click();
    }
    public void selectEnrollmentYear(String year){
        enrollmentYearSelect.click();
        enrollmentYearSelect.findElement(By.xpath("//*[contains(text(), \"" + year + "\")]")).click();
    }

    public void selectMajor(String major) {
        majorSelect.click();
        majorSelect.findElement(By.xpath("//*[contains(text(), \"" + major + "\")]")).click();
    }
    public void writeDateOfBirth(String date){
        dateOfBirth.sendKeys(date);
        dateOfBirth.sendKeys(Keys.RETURN);
    }
    public void writePhone(String phone){
        this.phone.sendKeys(phone);
    }
    public void selectCountry(String country){
        countrySelect.click();
        countrySelect.findElement(By.xpath("//*[contains(text(), \"" + country + "\")]")).click();
        phone.click();

    }
    public void submitForm(){
        email.submit();
    }

    public boolean getConfirmationMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.isDisplayed();
    }
    public StonybrookHomePage clickDoneConfirmation(){
        confirmationDone.click();
        return pageObjectsHandler.getStonybrookHomePage();
    }
    public StonybrookHomePage clickExitButton(){
        exitButton.click();
        return pageObjectsHandler.getStonybrookHomePage();
    }
}
