package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", plugin = { "pretty", "html:target/TestReport/testDDMMYY.html",
		 "json:target/json/file.json",
		 }, glue = { "step_Defination", "base" }, tags = "@Regrassion" )

public class RunnerTest {

}

//feature = path for test feature
//glue = Path for Step Defination
//tag = @smoke @ reg (for Execution) 
//plugin = Report Generation