import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber-reports"},
        glue = {"step_definitions"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
}