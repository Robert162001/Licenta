import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        plugin = {"pretty", "html:target/cucumber-reports"},
        glue = {"src/test/java/step_definitions"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}