package tests;

import org.testng.Assert;
import testutils.BaseTestProvider;
import webpages.Home;

public class BasicFlowsTest extends BaseTestProvider {

    public void navigateTest1() {
        Home home = new Home(webDriver);
        home.navigateTo();
        Assert.assertTrue(webDriver.getCurrentUrl().contains("robert-b.ro/"));
    }

    public void navigateTest2() {
        webDriver.navigate().to("http://robert-b.ro/contact/");
        Assert.assertTrue(webDriver.getCurrentUrl().contains("robert-b.ro/"));
    }
}
