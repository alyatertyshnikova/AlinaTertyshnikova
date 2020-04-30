package hw_jdi.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw_jdi.entities.MetalsAndColorsData;
import hw_jdi.sections.JdiMetalsAndColorsForm;

import java.util.List;

@Url("/metals-colors.html")
public class MetalsAndColorsPage extends WebPage {

    @Css(".results li")
    private WebList results;

    private JdiMetalsAndColorsForm jdiMetalsAndColorsForm;

    public void submitJdiMetalsAndColorsForm(MetalsAndColorsData metalsAndColorsData) {
        jdiMetalsAndColorsForm.submitForm(metalsAndColorsData);
    }

    public List<String> getResult() {
        return results.getValuesFast();
    }

}
