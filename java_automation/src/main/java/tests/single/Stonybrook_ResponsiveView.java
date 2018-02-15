package tests.single;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Stonybrook_ResponsiveView
{
	
public  WebDriver driver;
public  WebElement element;
 

	 JavascriptExecutor js = (JavascriptExecutor) driver;

	 public static final String USERNAME = "taherbaderkhan";
	 public static final String AUTOMATE_KEY = "3n24P5pZsMZvVgfTce4u";
	 public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	 public String GetURL = "https://www.youvisit.com/tour/stonybrook";
	 
	 public String continueinbrowser ="//*[@id='main']/div/div/div[1]/div[3]/div[2]" ;
	 
	 public String startbutton = "//*[@id='main']/div/div/div[1]/div/div[2]/a";
	 public String selection = "//*[@id='registration-visitortype']/div[1]/div[1]";
	 public String student   = "//*[@id='registration-visitortype']/div[1]/div[2]/div[1]/table[1]/tbody/tr/td[1]/div[3]";
	 public String studenttype = "//*[@id='registration-visitortype']/div[1]/div[2]/div[2]/table/tbody/tr/td[1]/div[2]";
	 public String FirstName = "//*[@id='firstname']";
	 public String LastName = "//*[@id='lastname']";
	 public String Email = "//*[@id='email']";
	 public String enrollyear = "enrollyear";
	 public String enyear_select = "//*[@id='enrollyear']/option[2]";
	 public String selectschool ="//*[@id='school']";
	 public String major = "major";
	 public String selmajor = "//*[@id='major']/option[2]";
	 public String gender = "gender";
	 public String gender_type ="option";
	 public String seldob =".//*[@id='registration-birthdate']";
	 public String selectday =".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[4]";
	 public String selectcountry ="country";
	 public String selectstreet ="us_street";
	 public String selectzip = "us_postal";
	 public String btnclick ="undefined_button";
	 public String phonenumber = "phone";
	 
	@BeforeTest
	public void COnnectBrowserStack() throws Exception
	{
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("device", "Samsung Galaxy S7");
		  caps.setCapability("os_version", "6.0");
		  caps.setCapability("real_mobile", "true");
		  caps.setCapability("browserstack.selenium_version", "3.8.1");
		  caps.setCapability("browserstack.appium_version", "1.6.5");

	    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get(GetURL);	    
	}


@Test
public void ContinueInBrowser()
	{
	
	element = driver.findElement(By.xpath(continueinbrowser));
	element.click();
	}
	
	@Test
	public void Startbutton()
	{
		element = driver.findElement(By.xpath(startbutton));
	    element.click();
	}
	
	@Test
	public void Registration_Visitor()
	{
		   element = driver.findElement(By.xpath(selection));  
            element.click();  
         
		    element = driver.findElement(By.xpath(student));
		    element.click();
		 
		  element = driver.findElement(By.xpath(studenttype));
		    element.click();
	}
	
	@Test
	public void FirstName() {
      element = driver.findElement(By.xpath(FirstName));
	    element.click();
	    element.sendKeys("Rajesh");
		
	}
	
	@Test
	public void LastName()
	{
		 element = driver.findElement(By.xpath(LastName));
		    element.click();
		    element.sendKeys("dronavalli");
	}
	
	@Test
	public void Email()
	{
		element = driver.findElement(By.xpath(Email));
	    element.click();
	    element.sendKeys("rdronavalli@qamentor");
	}
	
	@Test
	public void EnrollYear() 
	{
		element = driver.findElement(By.id(enrollyear));
	    WebElement year = element.findElement(By.xpath(enyear_select));
	     {
	        if("2018".equals(year.getText()))
	            year.click();   
	    }
	}
	
	@Test
	public void Select_School()
	{
		element= driver.findElement(By.xpath(selectschool));
	    element.sendKeys("USA High School");
	    
	}
	
	@Test
	public void Select_Major()
	{

		    element = driver.findElement(By.id(major));
		    js.executeScript("arguments[0].scrollIntoView();", element );
		    WebElement options = element.findElement(By.xpath(selmajor));
		     {
		        if("Africana Studies".equals(options.getText()))
		            options.click();   
		     }
		
	}
	
	@Test
	public void Select_Gender()
	{
		 element = driver.findElement(By.id(gender));
		    js.executeScript("arguments[0].scrollIntoView();", element);
		    List<WebElement> elements = element.findElements(By.tagName(gender_type));
		    for (WebElement opt : elements) {
		        if("Male".equals(opt.getText()))
		            opt.click();   
		    } 
	}

	@Test
	public void Select_DOB()
	{
		element = driver.findElement(By.xpath(seldob));
		element.click();
		 List<WebElement> dates = driver.findElements(By.xpath(selectday));
	     int count =dates.size();
	     for(int i=0; i<count; i++)
	     {
	    	 String d = dates.get(i).getText();
	    	 
	    	 if(d.equals("14"))
	    	 {
	    		 dates.get(i).click();

	    		 break;
	    	 }
	     }
	    
	}
	
	@Test
	public void PhoneNum()
	{
		element = driver.findElement(By.id(phonenumber));
		if(element.isDisplayed()) 
		{
			element.click();
			element.sendKeys("9033163249");
			
		}
		
	}
	
	@Test
	public void Select_drpcountry()
	{
		Select s = new Select(driver.findElement(By.id(selectcountry)));
	    s.selectByValue("USA");
	    
	    /* WebElement country = driver.findElement(By.id("country"));
	    js.executeScript("arguments[0].scrollIntoView();", country);
	    List<WebElement> c = country.findElements(By.xpath("//*[@id='country']/option[2]"));
	    for (WebElement cntry : c) {
	        if("USA".equals(cntry.getText()))
	            cntry.click();   
	    } */
      
	}
	
	@Test
	public void Street() 
	{
		 element = driver.findElement(By.id(selectstreet));
		 if(element.isDisplayed())
		  {
			 element.click();
			 element.sendKeys("3131 homestead road");
		  }
		
	}
	
   @Test
   public void Zip()
     {
	    element = driver.findElement(By.id(selectzip));
	 
	    if(element.isDisplayed())
	    {
	    	element.click();
	    	element.sendKeys("95051");

	    }  
       }
   
   @Test
   public void ButtonClick()
   {
	      element=   driver.findElement(By.id(btnclick));
	      element.click();
		    

   }
	
}
