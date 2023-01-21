import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import po.HomePage;

public class BaseTest {
    protected HomePage homePage;
    private WebDriver webDriver;

    protected WebDriver getWebDriver() {return this.webDriver; }

    @BeforeMethod
    public void init() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        EdgeOptions edgeOptions = new EdgeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");
        edgeOptions.addArguments("--window-size=1920,1080");
        // chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver = new EdgeDriver(edgeOptions);
        homePage = new HomePage(webDriver);
        homePage.navigateTo();
    }

    @AfterMethod
    public void closeDriver() {
        webDriver.quit();
    }

}
