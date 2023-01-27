package testutils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTestProvider {
    protected WebDriver webDriver;

    @BeforeMethod
    public void setupDriver() {
        webDriver = new WebDriverHandler().getWebDriver();
    }

    @AfterMethod
    public void closeDriver() {
        webDriver.quit();
    }


}
