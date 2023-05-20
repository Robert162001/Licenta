package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static testutils.BaseTestProvider.getPages;

public class Regression {

    private static final Logger logger = LogManager.getLogger(Regression.class);

    @When("the user select an interesting post and read it")
    public void theUserSelectAnInterestingPostAndReadIt() {
        logger.info("The user is able to see 3 post and choose what to read");
        getPages().blogPage().selectPost();
    }

    @Then("the user send a comment to that post")
    public void theUserSendACommentToThatPost() {
        logger.info("The user send his name and address and also send a comment");
        getPages().blogPage().commentOnPost();
    }
}
