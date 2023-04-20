package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static webpages.Home.HOME_PAGE_URL;

public class Trips {

    private final WebDriver webDriver;

    private static final String TRIPS_PAGE_URL = HOME_PAGE_URL + "trip/";

    public Trips(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() { webDriver.navigate().to(TRIPS_PAGE_URL); }

    public boolean isOnTripsPage() {
        return webDriver.getCurrentUrl().equals(TRIPS_PAGE_URL);
    }
}
