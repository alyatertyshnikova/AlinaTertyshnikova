package hw6.pages;

import hw6.composites.AbstractPageComposite;
import hw6.composites.HeaderMenu;
import hw6.composites.LeftSectionMenu;
import hw6.composites.LogComponent;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AbstractPage extends AbstractPageComposite {

    private HeaderMenu headerMenu;
    private LeftSectionMenu leftSectionMenu;
    private LogComponent logComponent;

    public AbstractPage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
        leftSectionMenu = new LeftSectionMenu(driver);
        logComponent = new LogComponent(driver);
    }

    public void clickHeaderMenuItem(String item) {
        headerMenu.clickHeaderItem(item);
    }

    public List<String> getHeaderMenuItems() {
        return headerMenu.getHeaderItemsText();
    }

    public String getNameOfLoggedInUser() {
        return headerMenu.getLoggedInUsernameText();
    }

    public void clickHeaderServiceItem(String item) {
        headerMenu.clickServiceItem(item);
    }

    public List<String> getLeftSectionItem() {
        return leftSectionMenu.getLeftSectionItemsText();
    }

    public Boolean isTitleHasCorrectName(String titleName) {
        return waitForTitle(titleName);
    }

    public List<String> getLogs() {
        return logComponent.getLogsText();
    }
}
