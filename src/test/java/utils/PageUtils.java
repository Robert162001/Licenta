package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtils {
    public static void scrollPage(WebDriver webDriver) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0, 1000)");
    }

    public static void sendText(WebDriver webDriver, By locator, String text) {
        WebElement element = webDriver.findElement(locator);
        element.sendKeys(text);
    }
}
