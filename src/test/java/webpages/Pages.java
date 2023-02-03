package webpages;

import org.openqa.selenium.WebDriver;

public class Pages {
    private WebDriver webDriver;
    private Home home;
    private Contact contact;
    private About about;

    public Pages(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public Home homePage() {
        return home == null ? new Home(webDriver) : this.home;
    }

    public Contact contactPage() {
        return contact == null ? new Contact(webDriver) : this.contact;
    }

    public About aboutPage() {return about == null ? new About(webDriver) : this.about;}

}
