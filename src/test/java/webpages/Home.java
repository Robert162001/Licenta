package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.using;

public class Home {

    private final WebDriver webDriver;

    private final By contactLink = By.xpath("//a[contains(@href, 'contact')]");
    private final By aboutLink = By.xpath("//a[contains(@href, 'about')]");

    private static final String HOME_PAGE_URL = "http://www.robert-b.ro/";

    public Home(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {
        webDriver.navigate().to(HOME_PAGE_URL);
    }

    public void clickOnContact() {
        using(webDriver, () -> $(contactLink).click());
    }

    public void clickOnAbout() {using(webDriver, () -> $(aboutLink).click());}
}
