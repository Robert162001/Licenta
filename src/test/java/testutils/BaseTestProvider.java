package testutils;

import org.openqa.selenium.WebDriver;


public class BaseTestProvider {
    protected WebDriver webDriver;

    public void setupDriver() {
        webDriver = new WebDriverHandler().getWebDriver();
    }

    public void closeDriver() {
        webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
