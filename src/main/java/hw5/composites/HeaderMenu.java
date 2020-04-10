package hw5.composites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderMenu extends AbstractPageComposite {

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerItems;

    @FindBy(id = "user-name")
    private WebElement loggedInUsername;

    @FindBy(css = "header .dropdown-menu li")
    private List<WebElement> serviceItems;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public void clickHeaderItem(String item) {
        clickItem(headerItems, item);
    }

    public String[] getHeaderItemsText() {
        return getListOfItemsText(headerItems);
    }

    public String getLoggedInUsernameText() {
        return waitForElement(loggedInUsername).getText();
    }

    public void clickServiceItem(String item) {
        clickItem(serviceItems, item);
    }
}
