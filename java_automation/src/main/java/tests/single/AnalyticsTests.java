package tests.single;

import automationFramework.pages.StonybrookHomePage;
import automationFramework.pages.StonybrookRegistrationPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;
import tests.base.TestBase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.assertTrue;

public class AnalyticsTests extends TestBase {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    //Generate auth key
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private String plaintext = "YVAuto-" + dateFormat.format(date);
    private String auth = DigestUtils.md5Hex( plaintext);

    @Test(groups = { "REGRESSION"})
    public void verifyingNextButtonAnalytics() throws Exception {
            stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
            stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
            assertTrue(stonybrookHomePage.navigateForwardButtonIsDisplayed(), "Navigate forward button was not detected.");
            stonybrookHomePage.clickNextButton();
            stonybrookHomePage.clickNextButton();
            stonybrookHomePage.clickNextButton();

            driver.navigate().refresh();

            //Get userkey
            String userkey = driver.manage().getCookieNamed("userkey").getValue();
            //Create analyticsURL
            String analyticsURL = BASE_URL + "/internals/validator/analytics/" + userkey + "?auth=" + auth + "&stops=3";
            System.out.println(analyticsURL);
            //Parse JSON from URL
            parseJSON(analyticsURL);
    }

    @Test(groups = { "REGRESSION"})
    public void verifyingArrowButtonAnalytics() throws Exception {
        stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
        stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
        assertTrue(stonybrookHomePage.navigateForwardButtonIsDisplayed(), "Navigate forward button was not detected.");
        stonybrookHomePage.clickNavigateForward();
        stonybrookHomePage.clickNavigateRight();
        stonybrookHomePage.clickNavigateForwardLeft();
        stonybrookHomePage.clickNavigateForward();
        stonybrookHomePage.clickNavigateForward();

        driver.navigate().refresh();

        //Get userkey
        String userkey = driver.manage().getCookieNamed("userkey").getValue();
        //Create analyticsURL
        String analyticsURL = BASE_URL + "/internals/validator/analytics/" + userkey + "?auth=" + auth + "&stops=2";
        System.out.println(analyticsURL);
        //Parse JSON from URL
        parseJSON(analyticsURL);
    }

    //Parse JSON and assert values
    private void parseJSON(String analyticsURL) throws Exception {
        JSONParser parser = new JSONParser();
        try {
            URL url = new URL(analyticsURL);
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONObject a = (JSONObject) parser.parse(inputLine);

                Boolean id = (Boolean) a.get("success");
                if (!id) {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    System.out.println(gson.toJson(a));
                }
                assertTrue(id);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
