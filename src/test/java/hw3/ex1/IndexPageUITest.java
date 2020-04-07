package hw3.ex1;

import hw3.AbstractBaseTest;
import hw3.pages.IndexPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IndexPageUITest extends AbstractBaseTest {

    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void checkIndexPageUIElements() {

        IndexPage indexPage = new IndexPage(driver);

        // 2. Assert Browser title
        softAssert.assertTrue(indexPage.isTitleHasCorrectName("Home Page"));

        // 3. Perform login
        String nameOfLoggedInUser = indexPage.login(resourceProperty.getValue("login"), resourceProperty.getValue("password"))
                .getNameOfLoggedInUser();

        // 4. Assert Username is loggined
        softAssert.assertEquals(nameOfLoggedInUser, resourceProperty.getValue("username"));

        // 5. Assert that there are 4 items on the header section are displayed and they have proper text
        String[] headerExpectedItems = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        softAssert.assertEquals(indexPage.getHeaderMenuItems(), headerExpectedItems);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(indexPage.isAllImagesDisplayed());

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] expectedTexts = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        softAssert.assertEquals(indexPage.getTextUnderImages(), expectedTexts);

        // 8. Assert that there is the iframe with "Frame Button" exist
        softAssert.assertTrue(indexPage.isFrameDisplayed());

        // 9. Switch to the iframe and check that there is "Frame Button" in the iframe
        Boolean visibilityOfFrameButton = indexPage.switchToFrame().isFrameButtonDisplayed();
        softAssert.assertTrue(visibilityOfFrameButton);

        // 10. Switch to original window back
        String[] leftSectionActualItems = indexPage.switchToDefaultFrame().getLeftSectionItem();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] leftSectionExpectedItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        softAssert.assertEquals(leftSectionActualItems, leftSectionExpectedItems);

        softAssert.assertAll();
    }

}
