package hw3.composites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPageComposite {
    protected WebDriver driver;

    protected AbstractPageComposite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickItem(List<WebElement> listOfItems, String itemName) {
        listOfItems.stream()
                .filter(item -> item.getText().equals(itemName))
                .findFirst()
                .map(this::waitForElementToBeClickable)
                .get()
                .click();
    }

    protected String[] getListOfItemsText(List<WebElement> listOfItems) {
        waitForAllElements(listOfItems);
        return listOfItems.stream()
                .map(WebElement::getText)
                .toArray(String[]::new);
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
