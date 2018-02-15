package automationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StonyBrook_ResponsiveWeb 
{
	
	 @FindBy(xpath ="//*[@id='main']/div/div/div[1]/div[3]/div[2]" )
	 WebElement continueinbrowser;
	 @FindBy(xpath ="//*[@id='main']/div/div/div[1]/div/div[2]/a")
	 WebElement startbutton;
	 @FindBy(xpath="//*[@id='registration-visitortype']/div[1]/div[1]")
	 WebElement selection;
	 @FindBy(xpath="\"//*[@id='registration-visitortype']/div[1]/div[2]/div[1]/table[1]/tbody/tr/td[1]/div[3]\"")
	 WebElement student;
	 @FindBy(xpath="//*[@id='registration-visitortype']/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]")
	 WebElement studenttype;
	 @FindBy(xpath="//*[@id='firstname']")
	 WebElement FirstName;
	 @FindBy(xpath="//*[@id='lastname']")
	 WebElement LastName;
	 @FindBy(xpath="//*[@id='email']")
	 WebElement Email;
	 @FindBy(id="enrollyear")
	 WebElement enrollyear;
	 @FindBy(xpath="//*[@id='enrollyear']/option[2]")
	 WebElement enyear_select;
	 @FindBy(xpath="//*[@id='school']")
	 WebElement selectschool;
	 @FindBy(id="major")
	 WebElement major;
	 @FindBy(xpath="//*[@id='major']/option[2]")
	 WebElement selmajor;
	 @FindBy(id="gender")
	 WebElement gender;
	 @FindBy(id="option")
	 WebElement gender_type;
     @FindBy(xpath=".//*[@id='registration-birthdate']")
     WebElement seldob;
     @FindBy(xpath=".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]")
     WebElement selectday;
     @FindBy(id="phone")
     WebElement phonenumber;
     @FindBy(id="country")
     WebElement selectcountry;
     @FindBy(id="us_street")
     WebElement selectstreet;
     @FindBy(id="us_postal")
     WebElement selectzip;
	 @FindBy(id="undefined_button")
	 WebElement btnclick;
	
	 
	 
	
	 
}
