package hw_jdi.pages;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw_jdi.entities.MetalsAndColorsData;

import java.util.List;

@Url("/metals-colors.html")
public class MetalsAndColorsPage {
    @JDropdown
    private Dropdown colors;
    @JDropdown
    private Dropdown metals;
    @JDropdown
    private Dropdown vegetables;
    @Css("#elements-checklist [type='checkbox']")
    private Checklist elements;
    @Css(".radio [type='radio']")
    private RadioButtons summary;
    @Css(".results li")
    private WebList results;
    @Css("#submit-button")
    private Button submit;

    public void selectSummary(String... summary) {
        this.summary.select(summary);
    }

    public void selectElements(String... elements) {
        this.elements.select(elements);
    }

    public void selectColors(String colors) {
        this.colors.select(colors);
    }

    public void selectMetals(String metals) {
        this.metals.select(metals);
    }

    public void selectVegetables(String... vegetables) {
        this.vegetables.select("Vegetables");
        this.vegetables.select(vegetables);
    }

    public void clickSubmitButton() {
        submit.click();
    }

    public List<String> getResult() {
        return results.getValuesFast();
    }
}
