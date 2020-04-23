package hw6;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.INSTANCE.createDriver("chrome");
        WebDriverSingleton.INSTANCE.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }
}
