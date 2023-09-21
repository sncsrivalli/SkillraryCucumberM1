package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/test/resources/featureFiles/skillrary.feature",
					glue = "stepdefinition",
					plugin = {"pretty",
							"html:target/HTML/report.html",
							"json:target/JSON/report.json",
							"junit:target/JUNIT/report.xml"
					})
public class TestRunner extends AbstractTestNGCucumberTests {

}
