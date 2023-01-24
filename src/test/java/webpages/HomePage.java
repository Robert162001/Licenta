package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver webDriver;

    private static final String HOME_PAGE_URL= "http://www.robert-b.ro/";

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {webDriver.navigate().to(HOME_PAGE_URL);}

}
