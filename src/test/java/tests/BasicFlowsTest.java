package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import webpages.HomePage;

public class BasicFlowsTest extends WebDriverManager {

    @Test
    public void navigateTest(){
        HomePage homePage = new HomePage(getWebDriver());
        homePage.navigateTo();
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("robert-b.ro/"));
    }
}
