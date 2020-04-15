package hw5.steps;

import hw5.WebDriverSingleton;
import hw5.pages.DifferentElementsPage;
import hw5.pages.IndexPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ActionSteps {

    private WebDriver driver;
    private IndexPage indexPage;
    private DifferentElementsPage differentElementsPage;

    public ActionSteps(){
        driver = WebDriverSingleton.INSTANCE.getDriver();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        differentElementsPage = PageFactory.initElements(driver, DifferentElementsPage.class);
    }

    @Step("I open {0} URL")
    public void open(String URL) {
        driver.get(URL);
    }

    @Step("I login as {0}")
    public void loginAs(String login, String password) {
        indexPage.login(login, password);
    }

    @Step("I open through the header menu Services -> {0} Page")
    public void openThroughHeaderItemService(String serviceCategory) {
        indexPage.clickHeaderMenuItem("SERVICE");
        indexPage.clickHeaderServiceItem(serviceCategory);
    }

    @Step("I select {0} checkboxes")
    public void selectCheckboxes(String... checkboxNames) {
        differentElementsPage.clickCheckbox(checkboxNames);
    }

    @Step("I select {0} radio button")
    public void selectRadio(String radioName) {
        differentElementsPage.clickRadios(radioName);
    }

    @Step("I select {0} in dropdown")
    public void selectOptionInDropdown(String option) {
        differentElementsPage.selectOptionInDropdown(option);
    }

    @Step("I close browser")
    public void close(){
        driver.quit();
    }
}
