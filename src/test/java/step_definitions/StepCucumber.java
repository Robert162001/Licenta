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

public class StepCucumber {
    private static final Logger logger = LogManager.getLogger(StepCucumber.class);

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

    @When("They navigate to Contact page")
    public void navigateToContactPage() {
        logger.info("Click on Contact");
        pages.homePage().clickOnContact();
    }

    @Then("They should be able to chat with customer support")
    public void verifyChatIsEnabled() {
        Assert.assertTrue(pages.contactPage().isOnContactPage());
    }


    @When("They navigate to About page")
    public void navigateToAboutPage() {
        logger.info("Click on About");
        pages.homePage().clickOnAbout();
    }

    @Then("They should see information about site")
    public void verifySiteInformation() {
        Assert.assertTrue(pages.aboutPage().isOnAboutPage());
    }


    @Then("They should be on the Home Page")
    public void theyShouldBeOnTheHomePage() {
        Assert.assertTrue(pages.contactPage().isOnContactPage());
    }
}