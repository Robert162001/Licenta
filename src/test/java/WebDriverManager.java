import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import po.HomePage;

public class WebDriverManager {
    protected HomePage homePage;
    private WebDriver webDriver;

    protected WebDriver getWebDriver() {return this.webDriver; }

    @BeforeMethod
    public void init() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);
        homePage = new HomePage(webDriver);
        homePage.navigateTo();
    }

    @AfterMethod
    public void closeDriver() {
        webDriver.quit();
    }

}
