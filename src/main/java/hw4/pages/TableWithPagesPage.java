package hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableWithPagesPage extends AbstractPage {
    @FindBy(tagName = "select")
    private WebElement showEntriesDropdown;

    @FindBy(css = "tbody > tr")
    private List<WebElement> tableRows;

    @FindBy(css = "#table-with-pages_filter input")
    private WebElement searchField;

    public TableWithPagesPage(WebDriver driver) {
        super(driver);
    }

    public String getDefaultDropdownValue() {
        Select select = new Select(waitForElement(showEntriesDropdown));
        return select.getFirstSelectedOption().getText();
    }

    public void selectNewDropdownValue(String newValue) {
        Select select = new Select(waitForElement(showEntriesDropdown));
        select.selectByValue(newValue);
    }

    public String getNumberOfTableRows() {
        return Integer.toString(waitForAllElements(tableRows).size());
    }

    public void sendKeysToSearchField(String searchText) {
        waitForElement(searchField).sendKeys(searchText);
    }

    public Boolean doTableResultsContainSearchText(String searchText) {
        return waitForAllElements(tableRows).stream()
                .allMatch(row -> row.getText().toLowerCase().contains(searchText));
    }
}
