package hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;

    @FindBy(className = "label-radio")
    private List<WebElement> radios;

    @FindBy(tagName = "select")
    private WebElement select;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckbox(List<String> checkboxName) {
        clickMultipleCheckboxes(checkboxes, checkboxName);
    }

    public void clickRadios(String radioName) {
        clickItem(radios, radioName);
    }

    public void selectOptionInDropdown(String option) {
        Select dropDown = new Select(waitForElement(select));
        dropDown.selectByVisibleText(option);
    }

}
