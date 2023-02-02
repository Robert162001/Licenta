package testutils;

import com.codeborne.selenide.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class WebDriverHandler {
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public WebDriverHandler(String... capabilities) {
        String browser = System.getProperty("browser", "chrome");
        switch (browser) {
            case Browsers.EDGE -> instantiateEdge();

            case Browsers.FIREFOX -> instantiateFirefox(capabilities);

            case Browsers.CHROME -> instantiateChrome(capabilities);

            default -> {
                instantiateChrome(capabilities);
            }
        }
    }

    private void instantiateChrome(String... capabilities) {
        chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(capabilities);
        webDriver = new ChromeDriver(chromeOptions);
    }

    private void instantiateFirefox(String... capabilities) {
        firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(capabilities);
        webDriver = new FirefoxDriver(firefoxOptions);
    }

    private void instantiateEdge() {
        edgedriver().setup();
        webDriver = new EdgeDriver();
    }
}
