package hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserTablePage extends AbstractPage {
    @FindBy(tagName = "select")
    private List<WebElement> dropdowns;

    @FindBy(css = "table a")
    private List<WebElement> usernames;

    @FindBy(css = "table span")
    private List<WebElement> descriptionTexts;

    @FindBy(css = "table input")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//table//tr/td[1]")
    private List<WebElement> indexes;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public Long displayedDropdownsNumber() {
        return getNumberOfDisplayedWebElements(dropdowns);
    }

    public Long displayedUsernamesNumber() {
        return getNumberOfDisplayedWebElements(usernames);
    }

    public Long displayedDescriptionTextsNumber() {
        return getNumberOfDisplayedWebElements(descriptionTexts);
    }

    public Long displayedCheckboxesNumber() {
        return getNumberOfDisplayedWebElements(checkboxes);
    }

    public List<String> getIndexes() {
        return getListOfItemsText(indexes);
    }

    public List<String> getDescriptionTexts() {
        return getListOfItemsText(descriptionTexts);
    }

    public List<String> getUsernames() {
        return getListOfItemsText(usernames);
    }

    public Integer getUserIndex(String username) {
        WebElement user = usernames.stream()
                .filter(name -> name.getText().equals(username))
                .findFirst()
                .get();
        return usernames.indexOf(user);
    }

    public List<String> getUserDropdownOptions(Integer userIndex) {
        Select select = new Select(dropdowns.get(userIndex));
        return getListOfItemsText(select.getOptions());
    }

    public void selectUserVipCheckbox(Integer userIndex) {
        checkboxes.get(userIndex).click();
    }

    private Long getNumberOfDisplayedWebElements(List<WebElement> webElements) {
        return webElements.stream()
                .filter(WebElement::isDisplayed)
                .count();
    }
}
