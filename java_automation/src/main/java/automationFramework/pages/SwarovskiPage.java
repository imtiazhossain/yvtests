package automationFramework.pages;

import automationFramework.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SwarovskiPage extends BasePage {

    public SwarovskiPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "skip_intro")
    WebElement skipButton;

    @FindBy(how = How.ID, using = "application")
    WebElement application;

    @FindBy(how = How.CSS, using = "#main > div > div > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > div:nth-child(3)")
    WebElement candleHotspot;

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Buy')]")
    WebElement buyButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/div/div[5]/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div[5]/div[3]")
    WebElement checkoutButton;

    @FindBy(how = How.NAME, using = "fullName")
    WebElement fullNameField;

    @FindBy(how = How.NAME, using = "address")
    WebElement addressField;

    @FindBy(how = How.NAME, using = "zipcode")
    WebElement zipcodeField;

    @FindBy(how = How.NAME, using = "email")
    WebElement emailField;

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Continue')]")
    WebElement continueButton;

    @FindBy(how = How.NAME, using = "cardholder-name")
    WebElement cardNameField;

    @FindBy(how = How.NAME, using = "cardnumber")
    WebElement cardNumberInputField;

    @FindBy(how = How.NAME, using = "exp-date")
    WebElement dateInputField;

    @FindBy(how = How.NAME, using = "cvc")
    WebElement cvcField;

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Proceed to Checkout')]")
    WebElement proceedButton;

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Place Order')]")
    WebElement placeOrderButton;

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'Continue Experience')]")
    WebElement continueExpButton;


    public void navigate() {
        driver.get("http://qa.dev.youvisit.com/tour/stonybrook");
    }

    @Override
    public By getPageLoadedLocator() {
        return By.xpath("//title[contains(text(),'Experience Swarovski in Virtual Reality')]");
    }

    public void clickSkipIntro() {
        skipButton.click();
    }

    public void clickApplication() {
        application.click();
    }

    public void clickHotspot() throws InterruptedException {
        Thread.sleep(1000);
        candleHotspot.click();
    }

    public void clickBuy() throws InterruptedException {
        buyButton.click();
        Thread.sleep(500);
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void inputName(String name){
        fullNameField.sendKeys(name);
    }

    public void inputAddress(String address){
        addressField.sendKeys(address);
    }

    public void inputZipcode(String zipcode){
        zipcodeField.sendKeys(zipcode);
    }

    public void inputEmail(String email){
        emailField.sendKeys(email);
    }

    public void clickContinue() throws InterruptedException {
        Thread.sleep(500);
        continueButton.click();
    }

    public void inputCardName(String name){
        cardNameField.sendKeys(name);
    }

    public void inputCardNumber(String number) {
        driver.switchTo().frame("__privateStripeFrame4");
        cardNumberInputField.sendKeys(number);
        driver.switchTo().defaultContent();
    }

    public void inputExpDate(String number)  {
        driver.switchTo().frame("__privateStripeFrame5");
        dateInputField.sendKeys(number);
        driver.switchTo().defaultContent();
    }

    public void inputCVC(String number) {
        driver.switchTo().frame("__privateStripeFrame6");
        cvcField.sendKeys(number);
        driver.switchTo().defaultContent();
    }

    public void clickSubmit() {
        proceedButton.click();
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }

    public void clickContinueExp() {
        continueExpButton.click();
    }
}
