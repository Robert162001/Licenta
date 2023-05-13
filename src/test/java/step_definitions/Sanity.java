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
import org.testng.Assert;
import testutils.BaseTestProvider;
import webpages.Pages;

import java.io.ByteArrayInputStream;

public class Sanity {
    private static final Logger logger = LogManager.getLogger(Sanity.class);

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


    @Given("the user is on Home page")
    public void navigateToHomePage() {
        pages.homePage().navigateTo();
    }

    @When("the user navigate to {string} page")
    public void navigateToEachPage(String page) {
        logger.info("Click on " + page);
        switch (page) {
            case "Blog" -> pages.homePage().clickOnBlog();
            case "Trips" -> pages.homePage().clickOnTrips();
            case "Destinations" -> pages.homePage().clickOnDestinations();
            case "TripTypes" -> pages.homePage().clickOnTripTypes();
            case "Activities" -> pages.homePage().clickOnActivities();
            default -> throw new IllegalArgumentException("Invalid page: " + page);
        }
    }

    @Then("the user is able to see {string}")
    public void verifyTheSpecificInformation(String information) {
        switch (information) {
            case "reviews" -> Assert.assertTrue(pages.blogPage().isOnBlogPage());
            case "trips" -> Assert.assertTrue(pages.tripsPage().isOnTripsPage());
            case "destinations" -> Assert.assertTrue(pages.destinationsPage().isOnDestinationsPage());
            case "triptypes" -> Assert.assertTrue(pages.tripTypesPage().isOnTripTypesPage());
            case "activities" -> Assert.assertTrue(pages.activitiesPage().isOnActivitiesPage());
            default -> throw new IllegalArgumentException("Invalid information: " + information);
        }
    }

    @Then("the user is able to see Home page")
    public void verifyHomePage() {
        Assert.assertTrue(pages.blogPage().isOnBlogPage());
    }

}