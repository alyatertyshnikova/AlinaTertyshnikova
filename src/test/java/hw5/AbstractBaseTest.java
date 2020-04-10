package hw5;

import hw5.steps.ActionSteps;
import hw5.steps.AssertionSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractBaseTest {
    protected WebDriver driver;
    protected ResourceProperty resourceProperty;
    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.INSTANCE.createDriver("chrome");
        driver = WebDriverSingleton.INSTANCE.getDriver();
        driver.manage().window().maximize();
        resourceProperty = new ResourceProperty("hw5/UserData");
        actionSteps = new ActionSteps();
        assertionSteps = new AssertionSteps();

        // Open test site by URL
        actionSteps.open("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @AfterMethod
    public void tearDown() {
        // Close browser
        actionSteps.close();
    }
}
