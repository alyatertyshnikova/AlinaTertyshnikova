package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class AbstractBaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @AfterMethod
    public void tearDown() {
        // Close browser
        driver.quit();
    }

    protected WebElement waitForElementLocatedBy(By by) {
        return new WebDriverWait(driver, 7)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> waitForAllElementsLocatedBy(By by) {
        return new WebDriverWait(driver, 7)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected Boolean waitForTitle(String title) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.titleIs(title));
    }

}
