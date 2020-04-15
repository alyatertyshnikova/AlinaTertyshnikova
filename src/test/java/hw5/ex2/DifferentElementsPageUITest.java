package hw5.ex2;

import hw5.AbstractBaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class DifferentElementsPageUITest extends AbstractBaseTest {

    @Feature("UI elements check")
    @Story("UI elements on the Different Elements Page check")
    @Test
    public void checkDifferentElementsPageUIElements() {

        // 2. Assert Browser title
        assertionSteps.titleNameShouldBe("Home Page");

        // 3. Perform login
        actionSteps.loginAs(resourceProperty.getValue("login"), resourceProperty.getValue("password"));

        // 4. Assert User name in the right-top side of screen that user is loggined
        assertionSteps.userIconTextShouldBe(resourceProperty.getValue("username"));

        // 5. Open through the header menu Service -> Different Elements Page
        actionSteps.openThroughHeaderItemService("DIFFERENT ELEMENTS");

        // 6. Select checkboxes
        actionSteps.selectCheckboxes("Water", "Wind");

        // 7. Select radio
        actionSteps.selectRadio("Selen");

        // 8. Select in dropdown
        actionSteps.selectOptionInDropdown("Yellow");

        // 9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value. 
        String[] expectedLogs = {"Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true"};
        assertionSteps.logsShouldBe(expectedLogs);

    }

}
