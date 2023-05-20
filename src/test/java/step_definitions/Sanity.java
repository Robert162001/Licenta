package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import static testutils.BaseTestProvider.getPages;

public class Sanity {

    private static final Logger logger = LogManager.getLogger(Sanity.class);

    @When("the user navigates to {string} page")
    public void navigateToEachPage(String page) {
        logger.info("Click on " + page);
        switch (page) {
            case "Home" -> getPages().homePage().navigateTo();
            case "Blog" -> getPages().homePage().clickOnBlog();
            case "Trips" -> getPages().homePage().clickOnTrips();
            case "Destinations" -> getPages().homePage().clickOnDestinations();
            case "TripTypes" -> getPages().homePage().clickOnTripTypes();
            case "Activities" -> getPages().homePage().clickOnActivities();
            default -> throw new IllegalArgumentException("Invalid page: " + page);
        }
    }

    @Then("the user is able to see {string}")
    public void verifyTheSpecificInformation(String information) {
        switch (information) {
            case "reviews" -> Assert.assertTrue(getPages().blogPage().isOnBlogPage());
            case "trips" -> Assert.assertTrue(getPages().tripsPage().isOnTripsPage());
            case "destinations" -> Assert.assertTrue(getPages().destinationsPage().isOnDestinationsPage());
            case "trip types" -> Assert.assertTrue(getPages().tripTypesPage().isOnTripTypesPage());
            case "activities" -> Assert.assertTrue(getPages().activitiesPage().isOnActivitiesPage());
            default -> throw new IllegalArgumentException("Invalid information: " + information);
        }
    }

}