package automationFramework.pages;

import automationFramework.handlers.YouvisitPageObjectsHandler;
import automationFramework.pages.base.YouvisitBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class StonybrookPage extends YouvisitBasePage {
    public StonybrookPage(WebDriver driver, YouvisitPageObjectsHandler handler) {
        super(driver, handler);
    }

    @FindBy(how = How.XPATH, using = "//*[@title=\"I am a *\"]")
    WebElement imA;

    @FindBy(how = How.XPATH, using = "//*[@item-value=\"prospective_student\"]") //item-value="prospective_student"
    WebElement optionProspectiveStudent;

    @FindBy(how = How.XPATH, using = "//*[@item-value=\"hs_grad\"]") //item-value="hs_grad"
    WebElement optionHighSchoolGraduate;

    @FindBy(how = How.XPATH, using = "//*[@title=\"First Name *\"]/input")
    WebElement firstName;
    @FindBy(how = How.XPATH, using = "//*[@title=\"Last Name *\"]/input")
    WebElement lastName;
    @FindBy(how = How.XPATH, using = "//*[@title=\"Email *\"]/input")
    WebElement email;
    @FindBy(how = How.XPATH, using = "//*[@title=\"Gender\"]/select")
    Select genderSelect;
    @FindBy(how = How.XPATH, using = "//*[@title=\"Enrollment Year *\"]/select")
    Select enrollmentYearSelect;
    @FindBy(how = How.XPATH, using = "//*[@title=\"Major\"]/select")
    Select majorSelect;
    @FindBy(how = How.XPATH, using = "//*[@title=\"Date of Birth *\"]/input")
    WebElement dateOfBirth;
    @FindBy(how = How.XPATH, using = "//*[@title=\"Phone\"]/input")
    WebElement phone;
    @FindBy(how = How.XPATH, using = "//*[@title=\"Country *\"]/select")
    Select countrySelect;


    //
    public void navigate(){
        driver.get("http://www.youvisit.com/tour/stonybrook");
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
    public void writeCompleteName(String first, String last){
        firstName.sendKeys(first);
        lastName.sendKeys(last);
    }
    public void writeEmail(String email){
        this.email.sendKeys(email);
    }
    public void selectGender(String gender){
        genderSelect.selectByVisibleText(gender);
    }
    public void selectEnrollmentYear(String year){
        enrollmentYearSelect.deselectAll();
        enrollmentYearSelect.selectByVisibleText(year);
    }

    public void selectMajor(String major) {
        majorSelect.selectByVisibleText(major);
    }
    public void writeDateOfBirth(String date){
        dateOfBirth.sendKeys(date);
    }
    public void writePhone(String phone){
        this.phone.sendKeys(phone);
    }
    public void selectCountry(String country){
        countrySelect.selectByVisibleText(country);
    }
}
