package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webpages.HomePage;

public class StepCucumber {
    private HomePage homePage;

    @Given("A user is on Home page")
    public void navigateToHomePage() {
        homePage.navigateTo();
    }

    @When("They navigate to Contact page")
    public void navigateToContactPage() {

    }

    @Then("They should be able to chat with customer support")
    public void verifyChatIsEnabled() {
    }
}