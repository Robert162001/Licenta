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

public class Regression {
    private static final Logger logger = LogManager.getLogger(Regression.class);

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


    @Given("the user navigate to Blog page")
    public void theUserNavigateToBlogPage(){
        logger.info("Navigate to Blog page");
        pages.blogPage().navigateTo();
    }

    @When("the user select an interesting post and read it")
    public void theUserSelectAnInterestingPostAndReadIt(){
        logger.info("The user is able to see 3 post and choose what to read");
        pages.blogPage().selectPost();
    }

    @Then("the user send a comment to that post")
    public void theUserSendACommentToThatPost(){
        logger.info("The user send his name and address and also send a comment");
        pages.blogPage().commentOnPost();
    }
}
