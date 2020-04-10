package hw4.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class MetalsAndColorsPage extends AbstractPage {
    @FindBy(className = "radio")
    private List<WebElement> radiosToSumm;

    @FindBy(css = "#elements-checklist .checkbox")
    private List<WebElement> elementsCheckboxes;

    @FindBy(css = "#colors li")
    private List<WebElement> colorsOptions;

    @FindBy(id = "colors")
    private WebElement colorsDropdown;

    @FindBy(css = "#metals li")
    private List<WebElement> metalsOptions;

    @FindBy(css = "#metals button")
    private WebElement metalsDropdown;

    @FindBy(css = "#vegetables li")
    private List<WebElement> vegetablesOptions;

    @FindBy(id = "vegetables")
    private WebElement vegetablesDropdown;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(css = ".results li")
    private List<WebElement> results;

    private JavascriptExecutor javascriptExecutor;

    public MetalsAndColorsPage(WebDriver driver) {
        super(driver);
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public MetalsAndColorsPage clickRadiosToSumm(String a, String b) {
        clickItem(radiosToSumm, a);
        clickItem(radiosToSumm, b);
        return this;
    }

    public MetalsAndColorsPage clickElementsCheckboxes(String[] elements) {
        clickMultipleCheckboxes(elementsCheckboxes, elements);
        return this;
    }

    public MetalsAndColorsPage selectColor(String color) {
        waitForElementToBeClickable(colorsDropdown).click();
        clickItem(colorsOptions, color);
        return this;
    }

    public MetalsAndColorsPage selectMetal(String metal) {
        jsClickButton(metalsDropdown);
        clickItem(metalsOptions, metal);
        return this;
    }

    public MetalsAndColorsPage selectVegetables(String[] vegetables) {
        waitForElementToBeClickable(vegetablesDropdown).click();
        clickItem(vegetablesOptions, "Vegetables");
        clickMultipleCheckboxes(vegetablesOptions, vegetables);
        return this;
    }

    public MetalsAndColorsPage clickSubmitButton() {
        jsClickButton(submitButton);
        return this;
    }

    public List<String> getResults() {
        return Arrays.asList(getListOfItemsText(results));
    }

    private void clickMultipleCheckboxes(List<WebElement> webElement, String[] checkboxes) {
        Arrays.asList(checkboxes).stream().forEach(checkbox -> clickItem(webElement, checkbox));
    }

    private void jsClickButton(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        javascriptExecutor.executeScript("arguments[0].click();", webElement);
    }
}
