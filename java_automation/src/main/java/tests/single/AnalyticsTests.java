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
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.assertTrue;

public class AnalyticsTests extends TestBase {

    private StonybrookRegistrationPage stonybrookRegistrationPage;
    private StonybrookHomePage stonybrookHomePage;

    @Severity(SeverityLevel.NORMAL)
    @Test(groups = { "REGRESSION"})
    public void verifyingThatTourLoads() throws Exception {
            stonybrookRegistrationPage = pageObjectsHandler.getStonybrookRegistrationPage();
            stonybrookHomePage = stonybrookRegistrationPage.clickExitButton();
            assertTrue(stonybrookHomePage.navigateForwardButtonIsDisplayed(), "Navigate forward button was not detected.");
            stonybrookHomePage.clickNextButton();
            stonybrookHomePage.clickNextButton();
            stonybrookHomePage.clickNextButton();

            //Generate auth key
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String plaintext = "YVAuto-" + dateFormat.format(date);
            String auth = DigestUtils.md5Hex( plaintext);
            System.out.println( auth );

            //Go to analytics JSON url
            String userkey = driver.manage().getCookieNamed("userkey").getValue();
            driver.navigate().refresh();
            String analyticsURL = BASE_URL + "/internals/validator/analytics/" + userkey + "?auth=" + auth + "&stops=3";
            System.out.println(analyticsURL);

            //Parse JSON and assert values
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
