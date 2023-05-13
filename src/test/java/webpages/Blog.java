package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PageUtils;

import static webpages.Home.HOME_PAGE_URL;

public class Blog {

    private final WebDriver webDriver;

    private final By button3 = By.xpath("//a[@class='primary-btn'][contains(@href, 'millennials')]");
    private final By commentArea = By.xpath("//*[@id='comment']");
    private final By nameArea = By.xpath("//*[@id='author']");
    private final By emailArea = By.xpath("//*[@id='email']");
    private final By submitComment = By.xpath("//*[@class='form-submit']//input[@name='submit']");

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

    public void selectPost() {
        PageUtils.scrollPage(webDriver);
        webDriver.findElement(button3).click();
        PageUtils.scrollPage(webDriver);
    }

    public void commentOnPost(){
        PageUtils.sendText(webDriver, commentArea, "Very good documentation!");
        PageUtils.sendText(webDriver, nameArea, "Robert");
        PageUtils.sendText(webDriver, emailArea, "robert@email.com");
        webDriver.findElement(submitComment).click();
    }
}
