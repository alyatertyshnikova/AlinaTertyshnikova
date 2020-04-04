package hw3.ex2;

import hw3.AbstractBaseTest;
import hw3.pages.DifferentElementsPage;
import hw3.pages.IndexPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageUITest extends AbstractBaseTest {

    @Test
    public void checkDifferentElementsPageUIElements() {
        IndexPage indexPage = new IndexPage(driver);

        // 2. Assert Browser title
        assertTrue(indexPage.isTitleHasCorrectName("Home Page"));

        // 3. Perform login
        indexPage.login(resourceProperty.getValue("login"), resourceProperty.getValue("password"));

        // 4. Assert User name in the right-top side of screen that user is loggined
        assertEquals(indexPage.getNameOfLoggedInUser(), resourceProperty.getValue("username"));

        // 5. Open through the header menu Service -> Different Elements Page
        indexPage.clickHeaderMenuItem("SERVICE");
        indexPage.clickHeaderServiceItem("DIFFERENT ELEMENTS");

        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);

        // 6. Select checkboxes
        differentElementsPage.clickCheckbox("Water");
        differentElementsPage.clickCheckbox("Wind");

        // 7. Select radio
        differentElementsPage.clickRadios("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectOptionInDropdown("Yellow");

        // 9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value. 
        String[] expectedLogs = {"Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true"};
        assertEquals(differentElementsPage.getLogs(), expectedLogs);

    }

}
