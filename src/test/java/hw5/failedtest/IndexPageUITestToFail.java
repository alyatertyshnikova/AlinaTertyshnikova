package hw5.failedtest;

import hw5.AbstractBaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class IndexPageUITestToFail extends AbstractBaseTest {

    @Feature("UI elements check")
    @Story("UI elements on the Index Page check")
    @Test
    public void checkIndexPageUIElements() {

        // 2. Assert Browser title
        assertionSteps.titleNameShouldBe("Home Page");

        // 3. Perform login
        actionSteps.loginAs(resourceProperty.getValue("login"), resourceProperty.getValue("password"));

        // 4. Assert Username is loggined
        assertionSteps.userIconTextShouldBe(resourceProperty.getValue("username"));

        // 5. Assert that there are items on the header section are displayed and they have proper text
        String[] headerExpectedItems = {"HOME", "CONTACT FORM", "SERVICES", "METALS & COLORS"};
        assertionSteps.itemsOnTheHeaderShouldBe(headerExpectedItems);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertionSteps.fourImagesOnIndexPageShouldBeDispalyed();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        String[] expectedTexts = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        assertionSteps.fourTextsUnderImagesOnIndexPageShouldBe(expectedTexts);

        // 8. Assert that there is the iframe with "Frame Button" exist
        assertionSteps.iframeShouldExist();

        // 9. Switch to the iframe and check that there is "Frame Button" in the iframe
        // 10. Switch to original window back
        assertionSteps.frameButtonShouldExist();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String[] leftSectionExpectedItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        assertionSteps.itemsInTheLeftSectionShouldBe(leftSectionExpectedItems);
    }

}
