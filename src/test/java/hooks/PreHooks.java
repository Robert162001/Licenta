package hooks;

import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import testutils.BaseTestProvider;

/**
 * Cucumber will run this before each scenario
 */
public class PreHooks {
    private static final Logger logger = LogManager.getLogger(PreHooks.class);

    @Before
    public void setup() {
        logger.info("== Pre hooks ==");
        new BaseTestProvider().setupDriver();
    }
}
