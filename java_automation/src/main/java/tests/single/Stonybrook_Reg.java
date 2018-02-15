package tests.single;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Stonybrook_Reg 
{
	public WebDriver driver;
	public WebElement element;
	public static final String USERNAME = "taherbaderkhan";
	public static final String AUTOMATE_KEY = "3n24P5pZsMZvVgfTce4u";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	private static final String YYYY = "";
	private static final String DD = "";
	private static final String MM = "";
	
	//xpaths
	public String continueinbrowser ="//*[@id='main']/div/div/div[1]/div[3]/div[2]";
	public String startbuttonclick ="//*[@id='main']/div/div/div[1]/div/div[2]/a";
	public String iamaselection ="//*[@id='registration-visitortype']/div[1]/div[1]";
	public String schoolclick ="//*[@id='registration-visitortype']/div[1]/div[2]/div[1]/table[1]/tbody/tr/td[1]/div[3]";
	public String schooltype ="//*[@id='registration-visitortype']/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]";
	public String fname ="//*[@id='firstname']";
	public String lname ="//*[@id='lastname']";
	public String email ="//*[@id='email']";
	public String enrollyear ="enrollyear";
	public String enyear ="//*[@id='enrollyear']/option[2]";
	public String school ="//*[@id='school']";
	public String majortype ="//*[@id='major']/option[2]";
	public String major ="major";
	public String gender = "gender";
	public String gendertype ="option";
	public String phnumber ="phone";
	public String country ="country";
	public String street ="us_street";
	public String zipcode ="us_postal";
	public String buttonclick ="undefined_button";
	
	

	@BeforeTest
	public void BrowserstackConnect() throws Exception
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("device", "Samsung Galaxy S7");
		  caps.setCapability("os_version", "6.0");
		  caps.setCapability("real_mobile", "true");
		  caps.setCapability("browserstack.selenium_version", "3.8.1");
		  caps.setCapability("browserstack.appium_version", "1.6.5");

	    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("https://www.youvisit.com/tour/stonybrook");	   
	}
	
	
            @Test
             public void Register()  
             {   
		    
		     driver.findElement(By.xpath(continueinbrowser)).click();
		     driver.findElement(By.xpath(startbuttonclick)).click();
		     driver.findElement(By.xpath(iamaselection)).click();  
             driver.findElement(By.xpath(schoolclick)).click();
             driver.findElement(By.xpath(schooltype)).click();
		    
            WebElement firstname = driver.findElement(By.xpath(fname));
            firstname.click();
		    firstname.sendKeys("Rajesh");
		    
		    WebElement lastname= driver.findElement(By.xpath(lname));
		    lastname.click();
	        lastname.sendKeys("dronavalli");
		     
	        WebElement emailid =  driver.findElement(By.xpath(email));
	        emailid.click();
		    emailid.sendKeys("rdronavalli@qamentor.com");
		    
		    WebElement y = driver.findElement(By.id(enrollyear));
		    WebElement year = y.findElement(By.xpath(enyear));
		    {
		        if("2018".equals(year.getText()))
		        {
		        year.click();   
		        }
		    }
		    
		    WebElement enterschool = driver.findElement(By.xpath(school));
		    enterschool.sendKeys("USA High School");
		    
	        JavascriptExecutor js = (JavascriptExecutor) driver;

		    WebElement m =  driver.findElement(By.id(major));
		    js.executeScript("arguments[0].scrollIntoView();", m);
		    WebElement options = m.findElement(By.xpath(majortype));
		    {
		        if("Africana Studies".equals(options.getText()))
		            options.click();   
		     }
		    
		   
		    WebElement g =  driver.findElement(By.id(gender));
		    js.executeScript("arguments[0].scrollIntoView();", g);
		    List<WebElement> g_type = g.findElements(By.tagName(gendertype));
		    for (WebElement opt : g_type) 
		    {
		        if("Male".equals(opt.getText()))
		            opt.click();   
		    } 
		    	
		     js.executeScript("document.getElementById('registration-birthdate').value='07/01/1990' ");
		    
		   WebElement phnum=  driver.findElement(By.id(phnumber));
		   phnum.click();
		   phnum.sendKeys("9033163249");

		    Select c = new Select(driver.findElement(By.id(country)));
		    c.selectByValue("USA");
		    
	
			  WebElement s_street=driver.findElement(By.id(street));
			  if(s_street.isDisplayed())
			   {
				  s_street.click();
				  s_street.sendKeys("3131 homestead road");
			    }
			    
			    
			    WebElement zip_code= driver.findElement(By.id(zipcode));
			    js.executeScript("arguments[0].scrollIntoView();", zip_code);
			    if(zip_code.isDisplayed())
			    {
			    	zip_code.click();
			    	zip_code.sendKeys("95051");
			    }  
			    
		WebElement btnclick = driver.findElement(By.id(buttonclick));
		btnclick.click();
	
		  
		  
		    
		   

	}
	  
}
