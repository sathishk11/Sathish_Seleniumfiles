package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/login.feature"}, glue = {"stepDefinitions"}, dryRun = false)

public class Runner extends AbstractTestNGCucumberTests {
	
}
