package hw6.steps;

import hw6.WebDriverSingleton;
import hw6.pages.DifferentElementsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DifferentPageSteps {
    private DifferentElementsPage differentElementsPage;

    public DifferentPageSteps() {
        differentElementsPage = new DifferentElementsPage(WebDriverSingleton.INSTANCE.getDriver());
    }

    @When("I select checkboxes with values:")
    public void iSelectAndCheckboxes(List<String> values) {
        differentElementsPage.clickCheckbox(values);
    }

    @When("I select {word} radio")
    public void iSelectRadio(String radio) {
        differentElementsPage.clickRadios(radio);
    }

    @When("I select {word} option in dropdown")
    public void iSelectOptionInDropdown(String option) {
        differentElementsPage.selectOptionInDropdown(option);
    }

    @Then("logs section contains log rows with values:")
    public void logsShouldContainValues(List<String> logs) {
        assertEquals(differentElementsPage.getLogs(), logs);
    }
}
