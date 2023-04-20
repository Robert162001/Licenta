package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static webpages.Home.HOME_PAGE_URL;

public class Destinations {

    private final WebDriver webDriver;

    private static final String DESTINATIONS_PAGE_URL = HOME_PAGE_URL + "destinations/";

    public Destinations(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {webDriver.navigate().to(DESTINATIONS_PAGE_URL);}

    public boolean isOnDestinationsPage(){return webDriver.getCurrentUrl().equals(DESTINATIONS_PAGE_URL);}

}
