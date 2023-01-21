import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicFlowsTest extends BaseTest{

    @Test
    public void navigateTest(){
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("http://www.robert-b.ro"));
    }
}
