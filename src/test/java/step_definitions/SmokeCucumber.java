package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testutils.BaseTestProvider;
import webpages.Pages;

import java.io.ByteArrayInputStream;

public class SmokeCucumber {
    private static final Logger logger = LogManager.getLogger(SmokeCucumber.class);

    private BaseTestProvider baseTestProvider;
    private Pages pages;

    @Before
    public void setup() {
        baseTestProvider = new BaseTestProvider();
        baseTestProvider.setupDriver();
        pages = new Pages(baseTestProvider.getWebDriver());
    }

    @After
    public void teardown(Scenario scenario) throws IllegalMonitorStateException {
        if (scenario.isFailed()) {
            Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot) baseTestProvider.getWebDriver()).getScreenshotAs(OutputType.BYTES)));
        }
        baseTestProvider.closeDriver();
    }

    @Given("A user navigate to Home page")
    public void navigateToHomePage(){
        logger.info("Navigate to www.robert-b.ro");
        pages.homePage().navigateTo();
    }

    @When("The site successfully loads")
    public void successfulLoadHomePage(){
        logger.info("The user should see the site");
        pages.homePage().isOnHomePage();
    }

    @Then("They should be able to see the title")
    public void seeTitlePage(){
        logger.info("The user should see the title of the site: Robert's Travel");
        pages.homePage().seeTitlePage();
    }

}
