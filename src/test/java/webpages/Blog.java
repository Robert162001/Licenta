package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static webpages.Home.HOME_PAGE_URL;

public class Blog {

    private final WebDriver webDriver;

    private static final String BLOG_PAGE_URL = HOME_PAGE_URL + "blog/";

    public Blog(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo() {
        webDriver.navigate().to(BLOG_PAGE_URL);
    }

    public boolean isOnBlogPage() {
        return webDriver.getCurrentUrl().equals(BLOG_PAGE_URL);
    }
}
