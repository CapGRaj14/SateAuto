package stepDefFile.RunnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\CHERRY\\workspace\\CucumberWithJava\\src\\test\\java\\Feature\\demoSite.feature",
		glue= {"stepDefFile"},
		strict = true,
		format = {"pretty","html:test-outout","junit:junit_xml/cucumber.xml"},
		dryRun = false,
		monochrome = true
		)
public class TestRunner {

}
