package tests.base;

import automationFramework.handlers.PageObjectsHandler;
import automationFramework.utils.GetProperties;
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

import java.net.URL;

import static automationFramework.utils.Utils.applyDefaultIfMissing;

public class BaseTest {

    protected WebDriver driver;
    private String environment = applyDefaultIfMissing(System.getProperty("environment"), "QA");
    protected GetProperties environmentProperties = new GetProperties(environment);
    public String platform = applyDefaultIfMissing(System.getProperty("platform"), environmentProperties.getString("PLATFORM").toUpperCase());
    private GetProperties platformProperties = new GetProperties(platform);
    private int port = environmentProperties.getInteger("APPIUM_PORT");
    protected PageObjectsHandler pageObjectsHandler;
    private String browser;

    @BeforeClass
    public void setUp() throws Exception {

        browser = applyDefaultIfMissing(System.getProperty("browser"), platformProperties.getString("BROWSER")).toUpperCase();

        switch (platform.toUpperCase()) {
            case "CLOUD":
                if (platformProperties.getString("MOBILE_EXECUTION").toUpperCase().equalsIgnoreCase("Yes")) {
                    //TODO: Implement Cloud Appium server execution
                } else {
                    String browserVersion = applyDefaultIfMissing(System.getProperty("browser_version"), platformProperties.getString("BROWSER_VERSION"));
                    String os = applyDefaultIfMissing(System.getProperty("os"), platformProperties.getString("OS"));
                    String osVersion = applyDefaultIfMissing(System.getProperty("os_version"), platformProperties.getString("OS_VERSION"));
                    String username = "taherbaderkhan";//System.getenv("CLOUD_USERNAME");
                    String password = "3n24P5pZsMZvVgfTce4u";//System.getenv("CLOUD_PASSWORD");
                    String url = "https://" + username + ":" + password + "@" + platformProperties.getString("CLOUD_PROVIDER");

                    DesiredCapabilities caps = new DesiredCapabilities();
                    if (browser.equalsIgnoreCase("firefox")) {
                        caps.setCapability("browserstack.selenium_version", "2.53.1");
                    }
                    caps.setCapability("name", "Build: " + System.getenv("BUILD_NUMBER"));
                    caps.setCapability("browser", browser);

                    if (!browserVersion.equalsIgnoreCase("latest"))
                        caps.setCapability("browser_version", browserVersion);

                    caps.setCapability("os", os);
                    caps.setCapability("os_version", osVersion);
                    caps.setCapability("browserstack.debug", "true");
                    caps.setCapability("resolution", "1920x1080");

                    driver = new RemoteWebDriver(new URL(url), caps);

                    // Console log configuration - Informative
                    System.out.println("# Operating System: " + os);
                    System.out.println("# Operating System Version: " + osVersion);
                    System.out.println("# Browser: " + browser);
                    System.out.println("# Browser Version: " + browserVersion);
                }

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

        pageObjectsHandler = PageObjectsHandler.getInstance(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        navigateToHome();
    }

    private void navigateToHome() {
        String BASE_URL = environmentProperties.getString("BASE_URL");
        driver.get(BASE_URL);
    }

    @AfterClass
    public void tearDown() {

        PageObjectsHandler.setInstanceNull();
        driver.quit();
    }
}