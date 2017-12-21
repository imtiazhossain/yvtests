package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
            features = "src/test/resources",
//            glue = {"stepDefinitions"},
            plugin = {"pretty", "html:target/cucumber-html-report" })
//            tags={"@Regression,@JunitScenario,@TestngScenario"})

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
