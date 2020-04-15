package hw6.steps;

import hw6.WebDriverSingleton;
import hw6.pages.UserTablePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserTablePageSteps {

    UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());

    @When("I select 'vip' checkbox for {string}")
    public void iSelectVipCheckboxFor(String username) {
        Integer userIndex = userTablePage.getUserIndex(username);
        userTablePage.selectUserVipCheckbox(userIndex);
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String titleName) {
        assertTrue(userTablePage.isTitleHasCorrectName(titleName));
    }

    @Then("{long} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void NumberTypeDropdownsShouldBeDisplayedOnUsersTablePage(Long dropdownsNumber) {
        assertEquals(userTablePage.displayedDropdownsNumber(), dropdownsNumber);
    }

    @Then("{long} Usernames should be displayed on Users Table on User Table Page")
    public void UsernamesShouldBeDisplayedOnUsersTableOnUserTablePage(Long usernameNumber) {
        assertEquals(userTablePage.displayedUsernamesNumber(), usernameNumber);
    }

    @Then("{long} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersPage(Long descriptionNumber) {
        assertEquals(userTablePage.displayedDescriptionTextsNumber(), descriptionNumber);
    }

    @Then("{long} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTablePage(Long checkboxesNumber) {
        assertEquals(userTablePage.displayedCheckboxesNumber(), checkboxesNumber);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainValues(DataTable values) {
        assertEquals(userTablePage.getIndexes(), values.rows(1).column(0));
        assertEquals(userTablePage.getUsernames(), values.rows(1).column(1));
        assertEquals(userTablePage.getDescriptionTexts(), values.rows(1).column(2));
    }

    @Then("droplist should contain values in column Type for user {word}")
    public void droplistForUserRomanShouldContainValues(String username, List<String> values) {
        Integer userIndex = userTablePage.getUserIndex(username);
        assertTrue(userTablePage.getUserDropdownOptions(userIndex).containsAll(values.subList(1, values.size())));
    }

    @Then("1 log row has {string} text in log section")
    public void logRowHasTextInLogSection(String logText) {
        assertTrue(userTablePage.getLogs().contains(logText));
    }
}
