package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesReader;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.using;

public class Home {

    private final WebDriver webDriver;

    private final By blogLink = By.xpath("//nav[@id='site-navigation']//a[contains(@href, 'blog')]");
    private final By tripsLink = By.xpath("//nav[@id='site-navigation']//a[contains(text(), 'All Trips')]");
    private final By destinationsLink = By.xpath("//a[contains(@href, 'destinations')]");
    private final By activitiesLink = By.xpath("//a[contains(@href, 'activities')]");
    private final By tripTypesLink = By.xpath("//a[contains(@href, 'trip-types')]");

    public static final String HOME_PAGE_URL = PropertiesReader.getProperty(PropertiesReader.TestProperty.BASE_URL);

    public Home(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {
        webDriver.navigate().to(HOME_PAGE_URL);
    }

    public void clickOnBlog() {
        using(webDriver, () -> $(blogLink).click());
    }

    public void clickOnTrips() {using(webDriver, () -> $(tripsLink).click());}

    public void clickOnDestinations() {using(webDriver, () -> $(destinationsLink).click());}

    public void clickOnActivities() {using(webDriver, () -> $(activitiesLink).click());}

    public void clickOnTripTypes() {using(webDriver, () -> $(tripTypesLink).click());}
}
