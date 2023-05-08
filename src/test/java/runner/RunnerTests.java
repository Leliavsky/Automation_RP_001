package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/smoke.feature",
        glue = "stepdefinitions"
)
public class RunnerTests extends AbstractTestNGCucumberTests {

}