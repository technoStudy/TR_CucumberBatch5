package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        tags = "@SmokeTest or @Regression", // bütün senaryolarda SmokeTest tag ine sahip olanları çalıştır
        features = {"src/test/java/FeatureFiles"}, //klasördeki bütün feature lar
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class _07_TestRunnerExtentReport extends AbstractTestNGCucumberTests {

}
