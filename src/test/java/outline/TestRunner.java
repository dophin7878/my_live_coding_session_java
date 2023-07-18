package outline;
 
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class) 
@CucumberOptions(format = {"pretty", "html:target/cucumber"},features = "src/test/resources/features/",glue={"stepDefinition"}) 

public class TestRunner { }