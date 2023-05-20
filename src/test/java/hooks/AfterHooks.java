package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testutils.BaseTestProvider;

import java.io.ByteArrayInputStream;

/**
 * Cucumber will run after each scenario
 */
public class AfterHooks {
    private static final Logger logger = LogManager.getLogger(AfterHooks.class);

    @After
    public void teardown(Scenario scenario) throws IllegalMonitorStateException {
        logger.info("== After hooks ==");
        if (scenario.isFailed()) {
            Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot) BaseTestProvider.getWebDriver()).getScreenshotAs(OutputType.BYTES)));
        }
        BaseTestProvider.closeDriver();
    }
}
