package po;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver webDriver;

    public HomePage(WebDriver webDriver) {this.webDriver = webDriver; }

    private static final String HOME_PAGE_URL= "http://www.robert-b.ro/";
    public void navigateTo() {webDriver.navigate().to(HOME_PAGE_URL);}

}
