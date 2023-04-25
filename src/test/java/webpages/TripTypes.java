package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static webpages.Home.HOME_PAGE_URL;

public class TripTypes {

    private final WebDriver webDriver;

    private static final String TRIPTYPES_PAGE_URL = HOME_PAGE_URL + "trip-types/";

    public TripTypes(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {webDriver.navigate().to(TRIPTYPES_PAGE_URL);}

    public boolean isOnTripTypesPage(){return webDriver.getCurrentUrl().equals(TRIPTYPES_PAGE_URL);}
}
