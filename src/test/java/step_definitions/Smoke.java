package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import static testutils.BaseTestProvider.getPages;

public class Smoke{

    private static final Logger logger = LogManager.getLogger(Smoke.class);

    @When("the site successfully loads")
    public void successfulLoadHomePage() {
        logger.info("The user connect to the site");
        getPages().homePage().isOnHomePage();
    }

    @Then("the user is able to see the title")
    public void seeTitlePage() {
        logger.info("The user see the title of the site: Robert's Travel");
        Assert.assertTrue(getPages().homePage().seeTitlePage());
    }


}
