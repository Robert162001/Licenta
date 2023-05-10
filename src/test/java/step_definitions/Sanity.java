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


    @Given("the user is on Home Page")
    public void navigateToHomePage() {
        pages.homePage().navigateTo();
    }

    @When("the user navigate to <page> page")
    public void navigateToEachPage(String page) {
        logger.info("Click on " + page);
        switch (page) {
            case "Blog":
                pages.homePage().clickOnBlog();
                break;
            case "Trips":
                pages.homePage().clickOnTrips();
                break;
            case "Destinations":
                pages.homePage().clickOnDestinations();
                break;
            case "TripTypes":
                pages.homePage().clickOnTripTypes();
                break;
            case "Activities":
                pages.homePage().clickOnActivities();
                break;
            default:
                throw new IllegalArgumentException("Invalid page: " + page);
        }
    }

    @Then("the user is able to see {string}")
    public void verifyTheSpecificInformation(String information) {
        switch (information) {
            case "reviews":
                Assert.assertTrue(pages.blogPage().isOnBlogPage());
                break;
            case "trips":
                Assert.assertTrue(pages.tripsPage().isOnTripsPage());
                break;
            case "destinations":
                Assert.assertTrue(pages.destinationsPage().isOnDestinationsPage());
                break;
            case "triptypes":
                Assert.assertTrue(pages.tripTypesPage().isOnTripTypesPage());
                break;
            case "activities":
                Assert.assertTrue(pages.activitiesPage().isOnActivitiesPage());
                break;
            default:
                throw new IllegalArgumentException("Invalid information: " + information);
        }
    }


//    @When("They navigate to Trips page")
//    public void navigateToTripsPage() {
//        logger.info("Click on Trips");
//        pages.homePage().clickOnTrips();
//    }
//
//    @Then("They should see information about trips")
//    public void siteInformation() {
//        Assert.assertTrue(pages.tripsPage().isOnTripsPage());
//    }
//
//
//
//    @When("They navigate to Destinations page")
//    public void navigateToDestinationsPage() {
//        logger.info("Click on Destination");
//        pages.homePage().clickOnDestinations();
//    }
//
//    @Then("They should see information about destinations")
//    public void informationAboutDestinations() {
//        Assert.assertTrue(pages.destinationsPage().isOnDestinationsPage());
//    }
//
//
//
//    @When("They navigate to TripTypes page")
//    public void navigateToTripTypesPage() {
//        logger.info("Click on TripTypes");
//        pages.homePage().clickOnTripTypes();
//    }
//
//    @Then("They should see information about triptypes")
//    public void informationAboutTriptypes() {
//        Assert.assertTrue(pages.tripTypesPage().isOnTripTypesPage());
//    }
//
//
//
//    @When("They navigate to Activities page")
//    public void navigateToActivitiesPage() {
//        logger.info("Click on Activities");
//        pages.homePage().clickOnActivities();
//    }
//
//    @Then("They should see information about activities")
//    public void informationAboutActivities() {
//        Assert.assertTrue(pages.activitiesPage().isOnActivitiesPage());
//    }




//    @Then("They should be on the Home Page")
//    public void verifyHomePage() {
//        Assert.assertTrue(pages.blogPage().isOnBlogPage());
//    }

}