package runner;


import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.TestNG;

import java.util.Collections;


@CucumberOptions(
        features = "src/main/resources/gmail.feature",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunnerTests extends AbstractTestNGCucumberTests {

}