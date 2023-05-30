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
    public void scrollToReadThePublishedArticleOnThePage(String arg0) {
        logger.info("The user is able to see 3 post and choose what to read");
        getPages().blogPage().selectPost();
    }

    @And("they click on {string} button")
    public void clickOnButton(String arg0) {
        logger.info("The user click on Read More");
        getPages().blogPage().clickOnReadMoreButton();
    }

    @And("they leave a comment with the following details")
    public void theyLeaveACommentWithTheFollowingDetails(List<Map<String, String>>params) {
        logger.info("The user send his information to specific boxes");
        getPages().blogPage().commentOnPost(params.get(0));
    }

    @Then("they see the comment published on the page")
    public void theySeeTheCommentPublishedOnThePage() {
        logger.info("The user is able to see if his comment was posted on the page");
        Assert.assertTrue(getPages().blogPage().visibleComment());
    }

    @And("they click to see all the destination from criteria")
    public void theyClickToSeeAllTheDestinationFromCriteria() {
        getPages().tripsPage().selectDestination();
    }
}
