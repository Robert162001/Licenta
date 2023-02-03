package webpages;

import org.openqa.selenium.WebDriver;

public class Pages {
    private WebDriver webDriver;
    private Home home;
    private Contact contact;

    public Pages(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Home homePage() {
        return home == null ? new Home(webDriver) : this.home;
    }

    public Contact contactPage() {
        return contact == null ? new Contact(webDriver) : this.contact;
    }

}
