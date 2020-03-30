package hw2.ex2;

import hw2.AbstractBaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageUITest extends AbstractBaseTest{

    @Test
    public void checkDifferentElementsPageUIElements() {

        // 2. Assert Browser title
        assertTrue(waitForTitle("Home Page"));

        // 3. Perform login
        waitForElementLocatedBy(By.id("user-icon")).click();
        waitForElementLocatedBy(By.id("name")).sendKeys("Roman");
        waitForElementLocatedBy(By.id("password")).sendKeys("Jdi1234");
        waitForElementLocatedBy(By.id("login-button")).click();

        // 4. Assert User name in the right-top side of screen that user is loggined
        assertEquals(waitForElementLocatedBy(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        waitForElementLocatedBy(By.xpath("//header//*[contains(text(), 'Service')]")).click();
        waitForElementLocatedBy(By.xpath("//header//*[contains(text(), 'Different elements')]")).click();

        // 6. Select checkboxes
        waitForElementLocatedBy(By.xpath("//label[contains(text()[normalize-space()], 'Water')]")).click();
        waitForElementLocatedBy(By.xpath("//label[contains(text()[normalize-space()], 'Wind')]")).click();

        // 7. Select radio
        waitForElementLocatedBy(By.xpath("//label[contains(text()[normalize-space()], 'Selen')]")).click();

        // 8. Select in dropdown
        Select dropDown = new Select(waitForElementLocatedBy(By.tagName("select")));
        dropDown.selectByVisibleText("Yellow");

        // 9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value. 
        List<WebElement> logs = waitForAllElementsLocatedBy(By.cssSelector(".panel-body-list.logs > li"));
        String[] expectedLogs = {"Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true"};
        for (int i = 0; i < expectedLogs.length; i++) {
            System.out.println(logs.get(i).getText()+"\n"+expectedLogs[i]);
            assertTrue(logs.get(i).getText().contains(expectedLogs[i]));
        }
    }

}
