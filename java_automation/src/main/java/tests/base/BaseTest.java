package tests.base;

import automationFramework.utils.AppiumServerJava;
import automationFramework.utils.GetProperties;
import automationFramework.utils.datatypes.BrowserType;
import automationFramework.utils.datatypes.PlatformType;
import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

import java.lang.reflect.Method;

import static automationFramework.utils.Utils.applyDefaultIfMissing;

public class BaseTest {

    protected static WebDriver driver;
    protected Eyes eyes;
    private static String environment = applyDefaultIfMissing(System.getProperty("environment"), "QA");
    protected static GetProperties properties = new GetProperties(environment);
    private static String browser = properties.getString("BROWSER").toUpperCase();
    private static String platform = properties.getString("PLATFORM").toUpperCase();
    private static String appName = properties.getString("APP_NAME");
    private static String apiKey = properties.getString("API_KEY");
    private static int port = properties.getInteger("APPIUM_PORT");
    private AppiumServerJava appiumServer;

    private BatchInfo batch;

    @Parameters({ "browser2", "platform2" }) //Added to parametrize browser
    @BeforeMethod
    public void setUp(Method method, @Optional("browser2") String browser2, @Optional("platform2") String platform2) throws Exception {
        //BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        try {
            browserType = BrowserType.valueOf(browser2.toUpperCase());
        } catch (IllegalArgumentException e) {

        }
        PlatformType platformType = PlatformType.valueOf(platform.toUpperCase());
        try {
            platformType = PlatformType.valueOf(platform2.toUpperCase());
        } catch (IllegalArgumentException e) {

        }
        if (platformType.equals(PlatformType.IOS) || platformType.equals(PlatformType.ANDROID)){
            appiumServer=new AppiumServerJava();

            if(!appiumServer.checkIfServerIsRunnning(port)) {
                appiumServer.startServer();
            } else {
                System.out.println("Appium Server already running on Port - " + port);
            }
        }
        DesiredCapabilities capabilities;
        String baseline = method.getName();
        String batchName;
        try {
            batchName = System.getenv("JOB_NAME");
            batch.setId(System.getenv("APPLITOOLS_BATCH_ID"));
        } catch (NullPointerException e) {
            batchName = "Local";
        }
        batch = new BatchInfo(batchName);
        configureApplitoolsEyes();
        switch (platformType){
            case MAC:
            case WINDOWS:
            switch (browserType) {
                case FIREFOX:
                    capabilities = DesiredCapabilities.firefox();
                    driver = new FirefoxDriver(capabilities);
                    baseline += " Firefox";
                    break;
                case CHROME:
                    capabilities = DesiredCapabilities.chrome();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-extensions");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    driver = new ChromeDriver(capabilities);
                    baseline += " Chrome";
                    break;
                case IE:
                    capabilities = DesiredCapabilities.internetExplorer();
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilities.setJavascriptEnabled(true);
                    capabilities.setCapability("requireWindowFocus", false);
                    capabilities.setCapability("enablePersistentHover", false);
                    capabilities.setCapability("ignoreProtectedModeSettings", true);
                    capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
                    capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                    driver = new InternetExplorerDriver(capabilities);
                    baseline += " Internet Explorer";
                    break;
                case SAFARI:
                    capabilities = DesiredCapabilities.safari();
                    driver = new SafariDriver(capabilities);
                    baseline += " Safari";
                    break;
                default:
                    capabilities = DesiredCapabilities.firefox();
                    driver = new FirefoxDriver(capabilities);
            }
            break;
            case IOS:
                capabilities=new DesiredCapabilities();
                capabilities.setCapability("platformName", "iOS");
                //For real device this is required
                //capabilities.setCapability("udid", "0d6503b781436c1ffe74629881f31700ce467c6a");
                capabilities.setCapability("deviceName", "iPad Air");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("platformVersion", "10.3");

                capabilities.setCapability("browserName", browserType);
                driver = new IOSDriver(capabilities);
                break;
            case ANDROID:
                //driver = new AppiumDriver();
            break;
        }
        try {
            driver.manage().window().maximize();
            driver = eyes.open(driver, appName, baseline);
            navigateToHome();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        driver.manage().deleteAllCookies();
    }

    private void navigateToHome() {
        String BASE_URL = properties.getString("BASE_URL");
        driver.get(BASE_URL);
    }

    private void configureApplitoolsEyes() {
        eyes = new Eyes();
        eyes.setApiKey(apiKey);
        eyes.setMatchLevel(MatchLevel.LAYOUT2);
        eyes.setSaveNewTests(false);
        eyes.setBatch(batch);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        try {
            if (appiumServer.checkIfServerIsRunnning(port))
                appiumServer.stopServer();
        }
        catch (NullPointerException e){

        }
        try {
            eyes.close();
        }
        finally {
            eyes.abortIfNotClosed();
            driver.quit();
        }
    }
}
