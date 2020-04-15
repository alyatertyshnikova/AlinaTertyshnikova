package hw5.steps;

import hw5.WebDriverSingleton;
import hw5.pages.DifferentElementsPage;
import hw5.pages.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionSteps {

    private WebDriver driver;
    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;

    public AssertionSteps() {
        driver = WebDriverSingleton.INSTANCE.getDriver();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        differentElementsPage = PageFactory.initElements(driver, DifferentElementsPage.class);
    }

    @Step("Title name should be {0}")
    public void titleNameShouldBe(String titleName) {
        assertTrue(indexPage.isTitleHasCorrectName(titleName));
    }

    @Step("User name in the right-top side of screen should be {0}")
    public void userIconTextShouldBe(String username) {
        assertEquals(indexPage.getNameOfLoggedInUser(), username);
    }

    @Step("Items on the header section should be {0} and displayed")
    public void itemsOnTheHeaderShouldBe(String[] expectedText) {
        assertEquals(indexPage.getHeaderMenuItems(), expectedText);
    }

    @Step("Four images on Index page should be displayed")
    public void fourImagesOnIndexPageShouldBeDispalyed() {
        assertTrue(indexPage.isAllImagesDisplayed());
    }

    @Step("Four texts under images on Index page should be {0}")
    public void fourTextsUnderImagesOnIndexPageShouldBe(String[] expectedText) {
        assertEquals(indexPage.getTextUnderImages(), expectedText);
    }

    @Step("iframe should be displayed")
    public void iframeShouldExist() {
        assertTrue(indexPage.isFrameDisplayed());
    }

    @Step("Frame button in the frame should be displayed")
    public void frameButtonShouldExist() {
        indexPage.switchToFrame();
        assertTrue(indexPage.isFrameButtonDisplayed());
        indexPage.switchToDefaultFrame();
    }

    @Step("Items on the left section should be {0} and displayed")
    public void itemsInTheLeftSectionShouldBe(String[] expectedText) {
        assertEquals(indexPage.getLeftSectionItem(), expectedText);
    }

    @Step("Log rows should be {0} and displayed")
    public void logsShouldBe(String[] expectedLogs) {
        assertEquals(differentElementsPage.getLogs(), expectedLogs);
    }
}
