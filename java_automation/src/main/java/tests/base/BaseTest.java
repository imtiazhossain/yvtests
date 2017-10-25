package tests.base;

import automationFramework.handlers.PageObjectsHandler;
import automationFramework.pages.StonybrookHomePage;
import automationFramework.utils.AppiumServerJava;
import automationFramework.utils.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

import static automationFramework.utils.Utils.applyDefaultIfMissing;

public class BaseTest {

    protected static WebDriver driver;
    private AppiumServerJava appiumServer;
    private static String environment = applyDefaultIfMissing(System.getProperty("environment"), "PROD");
    protected static GetProperties properties = new GetProperties(environment);
    private static String browser = properties.getString("BROWSER").toUpperCase();
    public static String platform = applyDefaultIfMissing(System.getProperty("platform"), properties.getString("PLATFORM").toUpperCase());
    private GetProperties platfotmProperties = new GetProperties(platform);
    private static int port = properties.getInteger("APPIUM_PORT");
    protected static PageObjectsHandler pageObjectsHandler;

    @BeforeMethod
    public void setUp() throws Exception {

        browser = applyDefaultIfMissing(System.getProperty("browser"), properties.getString("BROWSER"));

        switch (platform.toUpperCase()) {
            case "CLOUD":
                if (platfotmProperties.getString("MOBILE_EXECUTION").toUpperCase().equalsIgnoreCase("Yes")) {
                    //TODO: Implement Cloud Appium server execution
                } else {
                    String browserVersion = applyDefaultIfMissing(System.getProperty("browser_version"), platfotmProperties.getString("BROWSER_VERSION"));
                    String os = applyDefaultIfMissing(System.getProperty("os"), platfotmProperties.getString("OS"));
                    String osVersion = applyDefaultIfMissing(System.getProperty("os_version"), platfotmProperties.getString("OS_VERSION"));
                    String username = "taherbaderkhan";//System.getenv("CLOUD_USERNAME");
                    String password = "3n24P5pZsMZvVgfTce4u";//System.getenv("CLOUD_PASSWORD");
                    String url = "https://" + username + ":" + password + "@" + platfotmProperties.getString("CLOUD_PROVIDER");

                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability("name", "Build: " + System.getenv("BUILD_NUMBER"));
                    caps.setCapability("browser", browser);

                    if (!browserVersion.contains("latest")) caps.setCapability("browser_version", browserVersion);

                    caps.setCapability("os", os);
                    caps.setCapability("os_version", osVersion);
                    caps.setCapability("browserstack.debug", "true");
                    caps.setCapability("resolution", "1280x1024");
                    caps.setCapability("project", "IETests");

                    driver = new RemoteWebDriver(new URL(url), caps);

                    // Console log configuration - Informative
                    System.out.println("# Operating System: " + os);
                    System.out.println("# Operating System Version: " + osVersion);
                    System.out.println("# Browser: " + browser);
                    System.out.println("# Browser Version: " + browserVersion);
                }

                break;
            case "LOCAL":
                if (platfotmProperties.getString("MOBILE_EXECUTION").toUpperCase().equalsIgnoreCase("Yes")) {
                    startAppiumServer();
                    //TODO: Implement local Appium server execution
                } else {
                    switch (browser.toUpperCase()) {
                        case "FIREFOX":
                            FirefoxOptions firefoxOptions = new FirefoxOptions();
                           // firefoxOptions.setCapability("marionette", true);
                            driver = new FirefoxDriver(firefoxOptions);

                            break;
                        case "CHROME":
                            ChromeOptions chromeOptions = new ChromeOptions();
                            chromeOptions.addArguments("--disable-extensions");
                            driver = new ChromeDriver(chromeOptions);

                            break;
                        case "IE":
                            InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                            internetExplorerOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                            internetExplorerOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                            internetExplorerOptions.setCapability("requireWindowFocus", false);
                            internetExplorerOptions.setCapability("enablePersistentHover", false);
                            internetExplorerOptions.setCapability("ignoreProtectedModeSettings", true);
                            internetExplorerOptions.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
                            internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                            driver = new InternetExplorerDriver(internetExplorerOptions);

                            break;
                        case "SAFARI":
                            driver = new SafariDriver();

                            break;
                        default:

                            firefoxOptions = new FirefoxOptions();
                            //firefoxOptions.setCapability("marionette", true);
                            driver = new FirefoxDriver(firefoxOptions);

                            break;
                    }
                    break;
                }
        }
        pageObjectsHandler = PageObjectsHandler.getInstance(driver);
        driver.manage().deleteAllCookies();
        navigateToHome();

    }

    private void navigateToHome() {
        String BASE_URL = properties.getString("BASE_URL");
        driver.get(BASE_URL);
    }

    private void startAppiumServer() {
        appiumServer = new AppiumServerJava();

        if (!appiumServer.checkIfServerIsRunnning(port)) {
            appiumServer.startServer();
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }
    }

    @AfterMethod
    public void tearDown() {

        PageObjectsHandler.setInstanceNull();
        driver.quit();
    }
}