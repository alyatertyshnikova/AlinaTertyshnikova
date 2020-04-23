package hw6.steps;

import hw6.JsonParser;
import hw6.WebDriverSingleton;
import hw6.pages.IndexPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class IndexPageSteps {
    private IndexPage indexPage;
    private JsonParser jsonParser;

    public IndexPageSteps() {
        indexPage = new IndexPage(WebDriverSingleton.INSTANCE.getDriver());
        jsonParser = new JsonParser("src/test/resources/hw6/UserData.json");
    }

    @Given("I open JDI GitHub site")
    public void iOpenJDIGitHubSite() {
        WebDriverSingleton.INSTANCE.getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Given("I login as user {string}")
    public void iLoginAsUser(String username) {
        indexPage.login(jsonParser.getUserData(username, "login"), jsonParser.getUserData(username, "password"));
    }

    @When("I click on {string} button in Header")
    public void iClickOnButtonInHeader(String buttonName) {
        indexPage.clickHeaderMenuItem(buttonName);
    }

    @When("I click on {string} button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(String buttonName) {
        indexPage.clickHeaderServiceItem(buttonName);
    }
}
