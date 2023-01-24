package testutils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testutils.WebDriverHandler;


public class BaseTestProvider {
    private WebDriverHandler webdriverHandler;
    protected WebDriver webDriver;

    @BeforeMethod
    public void setupDriver() {
        webdriverHandler = new WebDriverHandler();
        webDriver = webdriverHandler.getWebDriver();
    }

    @AfterMethod
    public void closeDriver() {
        webDriver.quit();
    }


}
