package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractBaseTest {
    protected WebDriver driver;
    protected ResourceProperty resourceProperty;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        resourceProperty = new ResourceProperty("hw3/UserData");

        // Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

    }

    @AfterMethod
    public void tearDown() {
        // Close browser
        driver.quit();
    }
}
