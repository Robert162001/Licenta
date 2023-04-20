package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static webpages.Home.HOME_PAGE_URL;

public class Activities {

    private final WebDriver webDriver;

    private static final String ACTIVITIES_PAGE_URL = HOME_PAGE_URL + "activities/";

    public Activities(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {webDriver.navigate().to(ACTIVITIES_PAGE_URL);}

    public boolean isOnActivitiesPage(){return webDriver.getCurrentUrl().equals(ACTIVITIES_PAGE_URL);}
}
