package tests.base;

import automationFramework.handlers.PageObjectsHandler;
import automationFramework.utils.GetProperties;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.URL;

import static automationFramework.utils.Utils.applyDefaultIfMissing;

public class BaseTest {

    protected WebDriver driver;
    private String environment = applyDefaultIfMissing(System.getProperty("environment"), "QA");
    protected GetProperties environmentProperties = new GetProperties(environment);
    public String platform = applyDefaultIfMissing(System.getProperty("platform"), environmentProperties.getString("PLATFORM").toUpperCase());
    private GetProperties platformProperties = new GetProperties(platform);
    protected PageObjectsHandler pageObjectsHandler;
    private String browser;
    BatchInfo batchInfo;
    protected Eyes eyes;
    String apiKey = "wLyhbsIVo5WcAl111M3S2M9S8CvKp7sreC5sivufEj1108E110";

    @BeforeSuite
    public void beforeSuiteSetUp() {
        batchInfo = new BatchInfo(System.getenv("BUILD_NUMBER"));
    }

    @BeforeClass
    public void setUp() throws Exception {


        String testName = getClass().getName();
        browser = applyDefaultIfMissing(System.getProperty("browser"), platformProperties.getString("BROWSER")).toUpperCase();

        switch (platform.toUpperCase()) {
            case "CLOUD":

                String username = "taherbaderkhan";//System.getenv("CLOUD_USERNAME");
                String password = "3n24P5pZsMZvVgfTce4u";//System.getenv("CLOUD_PASSWORD");
                String url = "https://" + username + ":" + password + "@" + platformProperties.getString("CLOUD_PROVIDER");

                DesiredCapabilities caps = new DesiredCapabilities();

                if (platformProperties.getString("MOBILE_EXECUTION").toUpperCase().equalsIgnoreCase("YES")) {

                    String mobileDevice = applyDefaultIfMissing(System.getProperty("mobileDevice"), platformProperties.getString("MOBILE_DEVICE"));
                    String mobileOS = applyDefaultIfMissing(System.getProperty("mobileOS"), platformProperties.getString("MOBILE_OS"));
                    String mobileOsVersion = applyDefaultIfMissing(System.getProperty("mobileOsVersion"), platformProperties.getString("MOBILE_OS_VERSION"));

                    caps.setCapability("device", "iPhone 7");
                    caps.setCapability("realMobile", "true");
                    caps.setCapability("os_version", "10.0");


                } else {
                    String browserVersion = applyDefaultIfMissing(System.getProperty("browserVersion"), platformProperties.getString("BROWSER_VERSION"));
                    String os = applyDefaultIfMissing(System.getProperty("os"), platformProperties.getString("OS")).toUpperCase();
                    String osVersion = applyDefaultIfMissing(System.getProperty("osVersion"), platformProperties.getString("OS_VERSION"));

                    if (browser.equalsIgnoreCase("firefox")) {
                        caps.setCapability("browserstack.selenium_version", "2.53.1");
                        caps.setCapability("browser_version", "47.0.2");
                    }

                    caps.setCapability("name", "Build: " + System.getenv("BUILD_NUMBER"));
                    caps.setCapability("browser", browser);
                    caps.setCapability("os", os);
                    caps.setCapability("os_version", osVersion);
                    caps.setCapability("browserstack.debug", "true");
                    caps.setCapability("resolution", "1920x1080");

                    // Console log configuration - Informative
                    System.out.println("# Operating System: " + os);
                    System.out.println("# Operating System Version: " + osVersion);
                    System.out.println("# Browser: " + browser);
                    System.out.println("# Browser Version: " + browserVersion);
                }

                driver = new RemoteWebDriver(new URL(url), caps);

                break;
            case "LOCAL":
                if (platformProperties.getString("MOBILE_EXECUTION").toUpperCase().equalsIgnoreCase("Yes")) {
                    //TODO: Implement local Appium server execution
                } else {
                    switch (browser.toUpperCase()) {
                        case "FIREFOX":
                            FirefoxOptions firefoxOptions = new FirefoxOptions();
                            driver = new FirefoxDriver(firefoxOptions);

                            break;
                        case "CHROME":
                            ChromeOptions chromeOptions = new ChromeOptions();
                            chromeOptions.addArguments("--disable-extensions");
                            driver = new ChromeDriver(chromeOptions);

                            break;
                        case "IE":
                            InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                            driver = new InternetExplorerDriver();

                            break;
                        case "SAFARI":
                            SafariOptions safariOptions = new SafariOptions();
                            safariOptions.setUseTechnologyPreview(true);
                            safariOptions.setUseCleanSession(true);
                            driver = new SafariDriver(safariOptions);

                            break;
                        default:
                            firefoxOptions = new FirefoxOptions();
                            driver = new FirefoxDriver(firefoxOptions);

                            break;
                    }
                    break;
                }
        }

        configureApplitoolsEyes();

        if (platformProperties.getString("MOBILE_EXECUTION").toUpperCase().equalsIgnoreCase("YES")) {
            driver = eyes.open(driver, "YouvisitAppName", testName);
        } else {
            //driver = eyes.open(driver, "YouvisitAppName", testName, new RectangleSize(1024, 768));
            driver = eyes.open(driver, "YouvisitAppName", testName);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }

        pageObjectsHandler = PageObjectsHandler.getInstance(driver);
        navigateToHome();
    }

    private void navigateToHome() {
        String BASE_URL = environmentProperties.getString("BASE_URL");
        driver.get(BASE_URL);
    }


    private void configureApplitoolsEyes() {
        eyes = new Eyes();
        eyes.setApiKey(apiKey);
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.setSaveNewTests(true); //default true
        eyes.setSaveFailedTests(false); // default false
        eyes.setBatch(batchInfo);
    }

    @AfterClass
    public void tearDown() {
        try {
            PageObjectsHandler.setInstanceNull();
            eyes.close();
            //Abort eyes if it is not closed
            eyes.abortIfNotClosed();
        } catch (Exception e) {

        } finally {
            driver.quit();
        }
    }
}