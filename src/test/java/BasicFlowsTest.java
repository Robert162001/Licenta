import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicFlowsTest extends WebDriverManager {

    @Test
    public void navigateTest(){
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("robert-b.ro/"));
    }
}
