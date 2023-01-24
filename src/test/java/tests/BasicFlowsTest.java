package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testutils.BaseTestProvider;
import webpages.HomePage;

public class BasicFlowsTest extends BaseTestProvider {

    @Test
    public void navigateTest1() {
        HomePage homePage = new HomePage(webDriver);
        homePage.navigateTo();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("robert-b.ro/"));
    }

    @Test
    public void navigateTest2() {
        webDriver.navigate().to("http://robert-b.ro/contact/");
        Assert.assertTrue(webDriver.getCurrentUrl().contains("robert-b.ro/"));
    }
}
