package hw2.ex1;

import hw2.AbstractBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.*;

public class IndexPageUITest extends AbstractBaseTest {

    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void checkIndexPageUIElements() {

        // 2. Assert Browser title
        softAssert.assertTrue(waitForTitle("Home Page"));

        // 3. Perform login
        waitForElementLocatedBy(By.id("user-icon")).click();
        waitForElementLocatedBy(By.id("name")).sendKeys("Roman");
        waitForElementLocatedBy(By.id("password")).sendKeys("Jdi1234");
        waitForElementLocatedBy(By.id("login-button")).click();

        // 4. Assert Username is loggined
        softAssert.assertEquals(waitForElementLocatedBy(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper text
        List<WebElement> headerItems = waitForAllElementsLocatedBy(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8 > li"));
        String[] headerExpectedItems = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for (int i = 0; i < headerExpectedItems.length; i++) {
            assertEquals(headerItems.get(i).getText(), headerExpectedItems[i]);
        }

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = waitForAllElementsLocatedBy(By.className("benefit-icon"));
        softAssert.assertEquals(images.size(), 4);
        images.forEach((WebElement image) -> assertTrue(image.isDisplayed()));

        // 7. Assert that there are 4 tets on the Index Page under icons and they have proper text
        List<WebElement> texts = waitForAllElementsLocatedBy(By.className("benefit"));
        String[] expectedTexts = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        for (int i = 0; i < expectedTexts.length; i++) {
            softAssert.assertEquals(texts.get(i).getText(), expectedTexts[i]);
        }

        // 8. Assert that there is the iframe with "Frame Button" exist
        WebElement frame = waitForElementLocatedBy(By.id("frame"));
        softAssert.assertTrue(frame.isDisplayed());

        // 9. Switch to the iframe and check that there is "Frame Button" in the iframe
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        softAssert.assertTrue(waitForElementLocatedBy(By.id("frame-button")).isDisplayed());

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSectionItems = waitForAllElementsLocatedBy(By.cssSelector(".sidebar-menu > li"));
        String[] leftSectionExpectedItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        for (int i = 0; i < leftSectionExpectedItems.length; i++) {
            softAssert.assertEquals(leftSectionItems.get(i).getText(), leftSectionExpectedItems[i]);
        }

        softAssert.assertAll();
    }

}
