package hw2.ex1;

import hw2.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class IndexPageUITest extends AbstractBaseTest {

    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void checkIndexPageUIElements() {

        // 2. Assert Browser title
        softAssert.assertTrue(waitForTitle("Home Page"));

        // 3. Perform login
        waitForElementToBeClickable(By.id("user-icon")).click();
        waitForElementLocatedBy(By.id("name")).sendKeys("Roman");
        waitForElementLocatedBy(By.id("password")).sendKeys("Jdi1234");
        waitForElementToBeClickable(By.id("login-button")).click();

        // 4. Assert Username is loggined
        softAssert.assertEquals(waitForElementLocatedBy(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper text
        String[] headerItems = waitForAllElementsLocatedBy(By.cssSelector(".m-l8 > li")).stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
        String[] headerExpectedItems = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        softAssert.assertEquals(headerItems, headerExpectedItems);


        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = waitForAllElementsLocatedBy(By.className("benefit-icon"));
        softAssert.assertEquals(images.size(), 4);
        images.forEach((WebElement image) -> assertTrue(image.isDisplayed()));

        // 7. Assert that there are 4 tets on the Index Page under icons and they have proper text
        String[] texts = waitForAllElementsLocatedBy(By.className("benefit")).stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
        String[] expectedTexts = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        softAssert.assertEquals(texts, expectedTexts);


        // 8. Assert that there is the iframe with "Frame Button" exist
        WebElement frame = waitForElementLocatedBy(By.id("frame"));
        softAssert.assertTrue(frame.isDisplayed());

        // 9. Switch to the iframe and check that there is "Frame Button" in the iframe
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        softAssert.assertTrue(waitForElementToBeClickable(By.id("frame-button")).isDisplayed());

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] leftSectionItems = waitForAllElementsLocatedBy(By.cssSelector(".sidebar-menu > li")).stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
        String[] leftSectionExpectedItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        softAssert.assertEquals(leftSectionItems, leftSectionExpectedItems);

        softAssert.assertAll();
    }

}
