package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static testutils.BaseTestProvider.getPages;

public class Regression {

    private static final Logger logger = LogManager.getLogger(Regression.class);

    @And("they scroll to read the {string} published article on the page")
    public void scrollToReadThePublishedArticleOnThePage() {
        logger.info("The user is able to see 3 post and choose what to read");
        getPages().blogPage().selectPost();
    }

    @And("they click on {string} button")
    public void clickOnButton() {
        logger.info("The user click on Read More");
        getPages().blogPage().clickOnReadMoreButton();
    }

    @And("they leave a comment with the following details")
    public void leaveACommentWithTheFollowingDetails(List<Map<String, String>> params) {
        logger.info("The user send his information to specific boxes");
        getPages().blogPage().commentOnPost(params.get(0));
    }

    @Then("they see the comment published on the page")
    public void seeTheCommentPublishedOnThePage() {
        logger.info("The user is able to see if his comment was posted on the page");
        Assert.assertTrue(getPages().blogPage().isVisibleComment());
    }

    @And("they select {string} as destination")
    public void selectADestinationFromCriteriaMenu(String destination) {
        logger.info("The user select one of the destinations");
        getPages().tripsPage().selectDestination(destination);
    }

    @And("they click on show all trips from {string} section")
    public void clickToSeeAllTheDestinationFromCriteria(String section) {
        logger.info("The user expand the menu to see all the trip types");
        getPages().tripsPage().expandCriteriaMenu(section);
    }

    @And("they select {string} from menu")
    public void selectFromMenu(String tripTypes) {
        logger.info("The user select one of the trip types");
        getPages().tripsPage().selectTripType(tripTypes);
    }

    @Then("the user can see at least one trip displayed according to their searching criteria")
    public void chooseTheTripThatSuitsHisNeeds() {
        logger.info("The user is able to see the perfect trip for his needs");
        Assert.assertTrue(getPages().tripsPage().isVisibleTrip());
    }

}
