package hw6.composites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftSectionMenu extends AbstractPageComposite {

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSectionItems;

    public LeftSectionMenu(WebDriver driver) {
        super(driver);
    }

    public List<String> getLeftSectionItemsText() {
        return getListOfItemsText(leftSectionItems);
    }
}
