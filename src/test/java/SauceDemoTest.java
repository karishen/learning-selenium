import lv.acodemy.page_objects.LoginPage;
import lv.acodemy.page_objects.ProductsPage;
import lv.acodemy.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class SauceDemoTest {

    private static final Logger log = (Logger) LoggerFactory.getLogger(SauceDemoTest.class);
    Config config = Config.readConfig();
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;


    @BeforeMethod
    public void beforeTest() {
        //Initialize driver
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productsPage = new productsPage(driver);

    }

    @Test
    public void testSauceDemoSuccessLogin() {


        driver.get("https://www.saucedemo.com");
        loginPage.authorize("standard-user", "secret_sauce");

        Assert.assertEquals(productsPage.getProductsPageTitle().getText(), "Products");
    }

    @AfterMethod
    public void afterTest() {
        //Close driver
        driver.close();
        driver.quit();
    }
}
