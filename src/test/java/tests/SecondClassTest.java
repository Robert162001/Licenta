package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testutils.BaseTestProvider;

public class SecondClassTest extends BaseTestProvider {

    @Test
    public void navigateTest1() {
        webDriver.navigate().to("http://robert-b.ro/about/");
        Assert.assertTrue(webDriver.getCurrentUrl().contains("robert-b.ro/"));
    }
}
