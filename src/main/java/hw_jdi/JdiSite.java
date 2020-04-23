package hw_jdi;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw_jdi.pages.IndexPage;
import hw_jdi.pages.MetalsAndColorsPage;

public class JdiSite {

    public static IndexPage indexPage;
    public static MetalsAndColorsPage metalsAndColorsPage;
    @Css(".m-l8")
    public static Menu headerMenu;

    public static void open() {
        indexPage.open();
    }
}
