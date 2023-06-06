package webpages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.PageUtils;

import static webpages.Home.HOME_PAGE_URL;

public class Trips {

    private final WebDriver webDriver;

    private final By tripFound = By.xpath("//div[@class='wte-category-outer-wrap']");

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

    public void expandCriteriaMenu(String section) {
        WebElement showAll = webDriver.findElement(findShowAllButtonForSection(section));
        PageUtils.scrollToElement(webDriver, showAll);
        showAll.click();
    }

    private By findShowAllButtonForSection(String section) {
        return By.xpath(
                StringUtils.join(
                        "//h3[contains(text(),",
                        "'",
                        section,
                        "')]/following-sibling::div//button[@class='show-more']"));
    }

    private By destinationCheckBoxes(String destinationCheckBox) {
        return By.xpath(StringUtils.join("//input[@name='destination' and @value='", destinationCheckBox.toLowerCase(), "']/following-sibling::span"));
    }

    public void selectDestination(String destination) {
        webDriver.findElement(destinationCheckBoxes(destination)).click();
    }

    public By tripTypeCheckBoxes(String tripTypeCheckBox) {
        return By.xpath(StringUtils.join("//input[@name='trip_types' and @value='", tripTypeCheckBox.toLowerCase(), "']/following-sibling::span"));
    }

    public void selectTripType(String tripType) {
        webDriver.findElement(tripTypeCheckBoxes(tripType)).click();
    }

    public boolean visibleTrip() {
        WebElement element = webDriver.findElement(tripFound);
        PageUtils.scrollToElement(webDriver, element);
        return element.isDisplayed();
    }
}



