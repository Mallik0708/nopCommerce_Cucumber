package runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {".//Features/"},
			glue = "stepDefinitions",
			dryRun = false,
			plugin = {"pretty","html:target/test-output"},
			monochrome = true,
			tags= {"@sanity"}
		)

public class TestRunner {

}
