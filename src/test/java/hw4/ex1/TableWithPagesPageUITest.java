package hw4.ex1;

import hw4.AbstractBaseTest;
import hw4.pages.IndexPage;
import hw4.pages.TableWithPagesPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TableWithPagesPageUITest extends AbstractBaseTest {

    @Test
    public void checkTableWithPagesPageUIElements() {
        IndexPage indexPage = new IndexPage(driver);

        // 2. Assert Browser title
        assertTrue(indexPage.isTitleHasCorrectName("Home Page"));

        // 3. Perform login
        indexPage.login(resourceProperty.getValue("login"), resourceProperty.getValue("password"));

        // 4. Assert User name in the right-top side of screen that user is loggined
        assertEquals(indexPage.getNameOfLoggedInUser(), resourceProperty.getValue("username"));

        // 5. Open through the header menu Service -> Table with pages
        indexPage.clickHeaderMenuItem("SERVICE");
        indexPage.clickHeaderServiceItem("TABLE WITH PAGES");

        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage(driver);

        // 6. Check that default value for “Show entries” dropdown is 5
        assertEquals(tableWithPagesPage.getDefaultDropdownValue(), "5");

        // 7. Select new value for the entries in the dropdown list
        String newDropdownValue = "10";
        tableWithPagesPage.selectNewDropdownValue(newDropdownValue);

        // 8. Assert that in the table displayed corrected amount of entries
        assertEquals(tableWithPagesPage.getNumberOfTableRows(), newDropdownValue);

        // 9. Type in “Search” text field
        String textToSearch = "junit";
        tableWithPagesPage.sendKeysToSearchField(textToSearch);

        // 10. Assert the table contains only records with Search field value
        assertTrue(tableWithPagesPage.doTableResultsContainSearchText(textToSearch));
    }
}
