package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import testutils.BaseTestProvider;
import webpages.Pages;

public class StepCucumber {

    private BaseTestProvider baseTestProvider;
    private Pages pages;

    @Before
    public void setup() {
        baseTestProvider = new BaseTestProvider();
        baseTestProvider.setupDriver();
        pages = new Pages(baseTestProvider.getWebDriver());
    }

    @After
    public void teardown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll("", "_");
            if (scenario.isFailed()) {
                TakesScreenshot takesScreenshot = (TakesScreenshot) baseTestProvider.getWebDriver();
                byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseTestProvider.closeDriver();
    }

    @Given("A user is on Home page")
    public void navigateToHomePage() {
        pages.homePage().navigateTo();
    }

    @When("They navigate to Contact page")
    public void navigateToContactPage() {
        pages.homePage().clickOnContact();
    }

    @Then("They should be able to chat with customer support")
    public void verifyChatIsEnabled() {
        Assert.assertTrue(pages.contactPage().isOnContactPage());
    }


    @When("They navigate to About page")
    public void navigateToAboutPage() {
        pages.homePage().clickOnAbout();
    }

    @Then("They should see information about site")
    public void verifySiteInformation() {
        Assert.assertTrue(pages.aboutPage().isOnAboutPage());
    }

    @When("They press on search button")
    public void theyPressOnSearchButton() {

    }
}