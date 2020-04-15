package hw6.composites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractPageComposite {
    protected WebDriver driver;

    protected AbstractPageComposite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickItem(List<WebElement> listOfItems, String itemName) {
        listOfItems.stream()
                .filter(item -> item.getText().equalsIgnoreCase(itemName))
                .findFirst()
                .map(this::waitForElementToBeClickable)
                .get()
                .click();
    }

    protected List<String> getListOfItemsText(List<WebElement> listOfItems) {
        waitForAllElements(listOfItems);
        return listOfItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    protected void clickMultipleCheckboxes(List<WebElement> webElement, List<String> checkboxes) {
        checkboxes.forEach(checkbox -> clickItem(webElement, checkbox));
    }

    protected WebElement waitForElement(WebElement webElement) {
        return new WebDriverWait(driver, 7)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    protected List<WebElement> waitForAllElements(List<WebElement> webElements) {
        return new WebDriverWait(driver, 7)
                .until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    protected Boolean waitForTitle(String title) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.titleIs(title));
    }

    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        return new WebDriverWait(driver, 7)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
