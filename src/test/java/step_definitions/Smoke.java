package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import webpages.Pages;

public class Smoke {
    private static final Logger logger = LogManager.getLogger(Smoke.class);

    private Pages pages;



    @When("the site successfully loads")
    public void successfulLoadHomePage() {
        logger.info("The user connect to the site");
        pages.homePage().isOnHomePage();
    }

    @Then("the user is able to see the title")
    public void seeTitlePage() {
        logger.info("The user see the title of the site: Robert's Travel");
        pages.homePage().seeTitlePage();
    }

}
