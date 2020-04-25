package hw_jdi.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw_jdi.entities.MetalsAndColorsData;

public class JdiMetalsAndColorsForm extends Form<MetalsAndColorsData> {
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
    @Css("#submit-button")
    private Button submit;

    public void submitForm(MetalsAndColorsData metalsAndColorsData) {
        String[] summary = metalsAndColorsData.getSummary();
        this.summary.select(summary[0], summary[1]);
        this.elements.select(metalsAndColorsData.getElements());
        this.colors.select(metalsAndColorsData.getColor());
        this.metals.select(metalsAndColorsData.getMetals());
        this.vegetables.select("Vegetables");
        this.vegetables.select(metalsAndColorsData.getVegetables());
        submit.click();
    }
}
