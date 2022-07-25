package stepDefinition;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features"
		,glue={"stepDefinition"}
		,format={"pretty","html:target/Reports"}
		, dryRun=false
	
		)

public class Runner {

}