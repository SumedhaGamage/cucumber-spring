import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Sumedha on 7/9/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/"} , glue = "com.abc.amazon.automation.steps")
public class CucumberRunner {
}
