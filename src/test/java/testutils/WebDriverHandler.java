package testutils;

import com.codeborne.selenide.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class WebDriverHandler {
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public WebDriverHandler(String... capabilities) {
        String browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case Browsers.FIREFOX -> instantiateFirefox(capabilities);

            case Browsers.CHROME -> instantiateChrome(capabilities);

            default -> {
                instantiateChrome(capabilities);
            }
        }
    }

    private void instantiateChrome(String... capabilities) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments(capabilities);
        webDriver = new ChromeDriver(chromeOptions);
    }

    private void instantiateFirefox(String... capabilities) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(capabilities);
        webDriver = new FirefoxDriver(firefoxOptions);
        webDriver.manage().window().maximize();
    }

}
