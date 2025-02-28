package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/java/features",  // Changed path
	    glue = "stepDefinitions",
	    plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html",
	              "json:target/cucumber-reports/cucumber.json"},
	    monochrome = true
	)

public class TestRunner {
}
