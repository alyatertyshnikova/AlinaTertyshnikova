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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

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
        JdiSite.open();
        JdiSite.indexPage.login(User.ROMAN);
        JdiSite.headerMenu.select(HeaderMenuData.METALS_AND_COLORS);
    }

    @AfterMethod(alwaysRun = true)
    public void afterSuite() {
        WebDriverFactory.quit();
    }

    @Test(dataProvider = "jdiSubmitMetalsAndColorsFormDataProvider")
    public void jdiSubmitMetalsAndColorsForm(MetalsAndColorsData metalsAndColorsData) {
        JdiSite.metalsAndColorsPage.submitJdiMetalsAndColorsForm(metalsAndColorsData);
        assertThat(JdiSite.metalsAndColorsPage.getResult(), contains(metalsAndColorsData.getNonDefaultResultStrings()));
    }
}
