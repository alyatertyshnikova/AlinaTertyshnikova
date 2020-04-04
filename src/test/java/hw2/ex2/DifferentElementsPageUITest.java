package hw2.ex2;

import hw2.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageUITest extends AbstractBaseTest {

    @Test
    public void checkDifferentElementsPageUIElements() {

        // 2. Assert Browser title
        assertTrue(waitForTitle("Home Page"));

        // 3. Perform login
        waitForElementToBeClickable(By.id("user-icon")).click();
        waitForElementLocatedBy(By.id("name")).sendKeys("Roman");
        waitForElementLocatedBy(By.id("password")).sendKeys("Jdi1234");
        waitForElementToBeClickable(By.id("login-button")).click();

        // 4. Assert User name in the right-top side of screen that user is loggined
        assertEquals(waitForElementLocatedBy(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        waitForElementToBeClickable(By.linkText("SERVICE")).click();
        waitForElementToBeClickable(By.linkText("DIFFERENT ELEMENTS")).click();

        // 6. Select checkboxes
        waitForElementToBeClickable(By.xpath("//label[contains(text()[normalize-space()], 'Water')]")).click();
        waitForElementToBeClickable(By.xpath("//label[contains(text()[normalize-space()], 'Wind')]")).click();

        // 7. Select radio
        waitForElementToBeClickable(By.xpath("//label[contains(text()[normalize-space()], 'Selen')]")).click();

        // 8. Select in dropdown
        Select dropDown = new Select(waitForElementLocatedBy(By.tagName("select")));
        dropDown.selectByVisibleText("Yellow");

        // 9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value. 
        String[] logs = waitForAllElementsLocatedBy(By.cssSelector(".panel-body-list.logs > li")).stream()
                .map((WebElement log) -> log.getText().substring(9))
                .toArray(String[]::new);
        String[] expectedLogs = {"Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true"};
        assertEquals(logs, expectedLogs);
        
    }

}
