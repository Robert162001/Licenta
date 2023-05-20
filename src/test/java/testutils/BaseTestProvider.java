package testutils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import webpages.Pages;

import static com.codeborne.selenide.Selenide.using;

public class BaseTestProvider {
    private static WebDriver webDriver;
    private static Pages pages;

    public void setupDriver() {
        webDriver = new WebDriverHandler().getWebDriver();
        pages = new Pages(webDriver);
    }

    public static void closeDriver() {
        using(webDriver, Selenide::closeWebDriver);
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static Pages getPages() {
        return pages;
    }
}
