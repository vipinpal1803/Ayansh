package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = {"src/test/java/features"},
		dryRun = !true,
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		glue = {"steps","hooks"},
		plugin ={"pretty", "html:target/cucumber-reports.html",
				"json:reports/result.json",
				"junit:reports/result.xml"},
		tags = "@test"
		)

public class Runner extends AbstractTestNGCucumberTests {

}
