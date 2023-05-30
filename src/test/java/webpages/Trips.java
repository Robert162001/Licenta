package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.PageUtils;

import java.util.List;

import static webpages.Home.HOME_PAGE_URL;

public class Trips {

    private final WebDriver webDriver;

    private final By clickOnShowAll = By.xpath("//div//ul/li/button[1]");
    private final By london = By.xpath("//span[contains(text(), 'London')]");
    private final By weekendTrips = By.xpath("//span[contains(text(), 'Weekend Trips')]");
    private final By viewDetails = By.xpath("//a[contains(text(), 'View Details')]");

//    public enum Buttons {
//        BUTTON1, BUTTON2, BUTTON3
//    }

//    public void selectWhichButton(Buttons buttons) {
//        List<WebElement> showAllButtons = webDriver.findElements(clickOnShowAll);
//        switch (buttons) {
//            case BUTTON1 -> showAllButtons.get(0).click();
//            case BUTTON2 -> showAllButtons.get(1).click();
//            case BUTTON3 -> showAllButtons.get(2).click();
//        }
//    }

    private static final String TRIPS_PAGE_URL = HOME_PAGE_URL + "trip/";

    public Trips(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {
        webDriver.navigate().to(TRIPS_PAGE_URL);
    }

    public boolean isOnTripsPage() {
        return webDriver.getCurrentUrl().equals(TRIPS_PAGE_URL);
    }

    public void selectDestination() {
        List<WebElement> showAllButtons = webDriver.findElements(clickOnShowAll);
        PageUtils.scrollToElement(webDriver, showAllButtons.get(0));
        showAllButtons.get(0).click();
    }

//        webDriver.findElement(london).click();
//        PageUtils.scrollToElement(webDriver, showAllButtons.get(2));
//        showAllButtons.get(2).click();
//        webDriver.findElement(weekendTrips).click();
    }



