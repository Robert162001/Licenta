import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/features",
        plugin = {"pretty", "html:target/cucumber-reports"})
public class CucumberRunner extends AbstractTestNGCucumberTests {
}