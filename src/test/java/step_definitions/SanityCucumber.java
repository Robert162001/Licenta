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

public class SanityCucumber {
    private static final Logger logger = LogManager.getLogger(SanityCucumber.class);

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

    @Given("A user is on Home page")
    public void navigateToHomePage() {
        pages.homePage().navigateTo();
    }

    @When("They navigate to Blog page")
    public void navigateToBlogPage() {
        logger.info("Click on Blog");
        pages.homePage().clickOnBlog();
    }

    @Then("They should be able to see reviews")
    public void verifySeeReviews() {
        Assert.assertTrue(pages.blogPage().isOnBlogPage());
    }



    @When("They navigate to Trips page")
    public void navigateToTripsPage() {
        logger.info("Click on Trips");
        pages.homePage().clickOnTrips();
    }

    @Then("They should see information about trips")
    public void verifySiteInformation() {
        Assert.assertTrue(pages.tripsPage().isOnTripsPage());
    }



    @When("They navigate to Destinations page")
    public void theyNavigateToDestinationsPage() {
        logger.info("Click on Destination");
        pages.homePage().clickOnDestinations();
    }

    @Then("They should see information about destinations")
    public void theyShouldSeeInformationAboutDestinations() {
        Assert.assertTrue(pages.destinationsPage().isOnDestinationsPage());
    }



    @When("They navigate to TripTypes page")
    public void theyNavigateToTripTypesPage() {
        logger.info("Click on TripTypes");
        pages.homePage().clickOnTripTypes();
    }

    @Then("They should see information about triptypes")
    public void theyShouldSeeInformationAboutTriptypes() {
        Assert.assertTrue(pages.tripTypesPage().isOnTripTypesPage());
    }



    @When("They navigate to Activities page")
    public void theyNavigateToActivitiesPage() {
        logger.info("Click on Activities");
        pages.homePage().clickOnActivities();
    }

    @Then("They should see information about activities")
    public void theyShouldSeeInformationAboutActivities() {
        Assert.assertTrue(pages.activitiesPage().isOnActivitiesPage());
    }




    @Then("They should be on the Home Page")
    public void theyShouldBeOnTheHomePage() {
        Assert.assertTrue(pages.blogPage().isOnBlogPage());
    }



}