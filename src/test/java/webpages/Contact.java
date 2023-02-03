package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Contact {

    private final WebDriver webDriver;

    private static final String CONTACT_PAGE_URL = "http://robert-b.ro/contact/";

    public Contact(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {
        webDriver.navigate().to(CONTACT_PAGE_URL);
    }

    public boolean isOnContactPage() {
        return webDriver.getCurrentUrl().equals(CONTACT_PAGE_URL);
    }
}
