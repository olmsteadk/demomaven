package cucumberTest;


import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
		features = "Feature/Checkout.feature"
		,glue={"stepDefinition"}
		)

public class TestRunner {

}
