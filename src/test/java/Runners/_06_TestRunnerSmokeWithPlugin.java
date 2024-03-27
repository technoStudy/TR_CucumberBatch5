package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false, // true olduğunda testleri çalıştırmaz, sadece STEP leri var mı kontrol eder
        plugin = {"html:target/site/cucumber-pretty.html"} //basit report
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
