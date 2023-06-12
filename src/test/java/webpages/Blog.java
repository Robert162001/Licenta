package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.PageUtils;
import utils.RandomUtils;

import java.util.List;
import java.util.Map;

import static testutils.TestConstants.*;
import static webpages.Home.HOME_PAGE_URL;

public class Blog {

    private final WebDriver webDriver;

    private final By button3 = By.xpath("//a[@class='primary-btn'][contains(@href, 'millennials')]");
    private final By commentArea = By.xpath("//*[@id='comment']");
    private final By nameArea = By.xpath("//*[@id='author']");
    private final By emailArea = By.xpath("//*[@id='email']");
    private final By submitComment = By.xpath("//*[@class='form-submit']//input[@name='submit']");
    private final By comments = By.xpath("//div//ol/li");

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
        WebElement element = webDriver.findElement(button3);
        PageUtils.scrollToElement(webDriver, element);
    }

    public void clickOnReadMoreButton() {
        webDriver.findElement(button3).click();
    }

    public void commentOnPost(Map<String, String> params) {
        WebElement element = webDriver.findElement(submitComment);
        PageUtils.scrollToElement(webDriver, element);
        String userName = RandomUtils.generateRandomString(5, 11);
        String userEmail = RandomUtils.generateEmailAddressByUserName(userName);

        if (isMapKeyExists(params, COMMENT)) {
            webDriver.findElement(commentArea).sendKeys(params.get(COMMENT) + PageUtils.getTimeStamp());
        }

        if (isMapKeyExists(params, NAME)) {
            webDriver.findElement(nameArea).sendKeys(params.get(NAME).equalsIgnoreCase(RANDOM) ? userName : params.get(NAME));
        }

        if (isMapKeyExists(params, EMAIL)) {
            webDriver.findElement(emailArea).sendKeys(params.get(EMAIL).contains(RANDOM) ? userEmail : params.get(EMAIL));
        }

        element.click();
    }

    public boolean isVisibleComment() {
        List<WebElement> commentElement = webDriver.findElements(comments);
        WebElement lastComment = commentElement.get(commentElement.size() - 1);
        return lastComment.isDisplayed();
    }

    private boolean isMapKeyExists(Map<String, String> paramsMap, String mapKey) {
        if (!paramsMap.containsKey(mapKey)) {
            throw new IllegalArgumentException(mapKey + " does not exist");
        }
        return true;
    }

}
