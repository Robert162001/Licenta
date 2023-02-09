package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static webpages.Home.HOME_PAGE_URL;

public class About {

    private final WebDriver webDriver;

    private static final String ABOUT_PAGE_URL = HOME_PAGE_URL + "about/";

    public About(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {
        webDriver.navigate().to(ABOUT_PAGE_URL);
    }

    public boolean isOnAboutPage() {
        return webDriver.getCurrentUrl().equals(ABOUT_PAGE_URL);
    }
}
