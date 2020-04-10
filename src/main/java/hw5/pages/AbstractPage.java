package hw5.pages;

import hw5.composites.AbstractPageComposite;
import hw5.composites.HeaderMenu;
import hw5.composites.LeftSectionMenu;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends AbstractPageComposite {

    private HeaderMenu headerMenu;
    private LeftSectionMenu leftSectionMenu;

    public AbstractPage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
        leftSectionMenu = new LeftSectionMenu(driver);
    }

    public void clickHeaderMenuItem(String item) {
        headerMenu.clickHeaderItem(item);
    }

    public String[] getHeaderMenuItems() {
        return headerMenu.getHeaderItemsText();
    }

    public String getNameOfLoggedInUser() {
        return headerMenu.getLoggedInUsernameText();
    }

    public void clickHeaderServiceItem(String item) {
        headerMenu.clickServiceItem(item);
    }

    public String[] getLeftSectionItem() {
        return leftSectionMenu.getLeftSectionItemsText();
    }

    public Boolean isTitleHasCorrectName(String titleName) {
        return waitForTitle(titleName);
    }
}
