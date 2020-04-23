package hw_jdi;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.init.PageFactory;
import hw_jdi.entities.HeaderMenuData;
import hw_jdi.entities.MetalsAndColorsData;
import hw_jdi.entities.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class JdiTest {
    @DataProvider
    public Object[] jdiSubmitMetalsAndColorsFormDataProvider() {
        return JsonParser.getObjectsFromJson(
                "src/test/resources/hw_jdi/JDI_ex8_metalsColorsDataSet.json",
                MetalsAndColorsData[].class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterMethod(alwaysRun = true)
    public void afterSuite() {
        WebDriverFactory.quit();
    }

    @Test(dataProvider = "jdiSubmitMetalsAndColorsFormDataProvider")
    public void jdiSubmitMetalsAndColorsForm(MetalsAndColorsData metalsAndColorsData) {
        JdiSite.open();
        JdiSite.indexPage.login(User.ROMAN);
        JdiSite.headerMenu.select(HeaderMenuData.METALS_AND_COLORS);

        String[] summary = metalsAndColorsData.getSummary();
        JdiSite.metalsAndColorsPage.selectSummary(summary[0], summary[1]);
        JdiSite.metalsAndColorsPage.selectElements(metalsAndColorsData.getElements());
        JdiSite.metalsAndColorsPage.selectColors(metalsAndColorsData.getColor());
        JdiSite.metalsAndColorsPage.selectMetals(metalsAndColorsData.getMetals());
        JdiSite.metalsAndColorsPage.selectVegetables(metalsAndColorsData.getVegetables());
        JdiSite.metalsAndColorsPage.clickSubmitButton();

        assertTrue(metalsAndColorsData.getNonDefaultResultStrings().containsAll(JdiSite.metalsAndColorsPage.getResult()));
    }
}
