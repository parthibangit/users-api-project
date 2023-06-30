package common.featurerunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue= {"stepdefinitions"},
        tags = "@smoke",
//        dryRun = true,
        monochrome = true,
        plugin =  {"pretty", "html:src/test/resources/cucumber-reports/report.html"}

)
public class FeatureRunner {


}
