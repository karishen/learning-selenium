import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SimpleTest {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);

    @Test
    public void mySimpleTest() {
        logger.info("Initializing ChromeDriver");

        WebDriver driver = new ChromeDriver();

        //Get method
        logger.info("Opening URL: https://google.com");
        driver.get("https://google.com");

        logger.info("Accept cookies n stuff");
        driver.findElement(By.id("L2AGLb")).click();

        logger.info("Searching for acodemy.lv");
        driver.findElement(By.name("q")).sendKeys("acodemy.lv");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        logger.info("Validate search result count");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0, 1000);");

        List<WebElement> results = driver.findElements(By.xpath("//h3[contains(@class,'LC20lb')]"));
        Assert.assertEquals(results.size(), 16);

        //Close browser
        logger.info("Closing ChromeDriver");
        driver.close();
        driver.quit();

    }
}
