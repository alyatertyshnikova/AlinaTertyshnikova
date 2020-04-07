package hw4.ex2;

import hw4.AbstractBaseTest;
import hw4.DataForMetalsAndColorsPage;
import hw4.pages.IndexPage;
import hw4.pages.MetalsAndColorsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class MetalsAndColorsPageUITest extends AbstractBaseTest {

    @DataProvider
    public Object[][] metalsAndColorsPageDataProvider() {
        return new Object[][]{
                {DataForMetalsAndColorsPage.builder().setElements("Earth").setColor("Yellow").setMetal("Gold").build()},
                {DataForMetalsAndColorsPage.builder().setA("3").setB("8").setVegetables("Cucumber", "Tomato").build()},
                {DataForMetalsAndColorsPage.builder().setA("3").setB("2")
                        .setElements("Water", "Wind", "Fire").setMetal("Bronze").setVegetables("Onion").build()},
                {DataForMetalsAndColorsPage.builder().setA("6").setB("5").setElements("Water").setColor("Green")
                        .setMetal("Selen").setVegetables("Cucumber", "Tomato", "Vegetables", "Onion").build()},
                {DataForMetalsAndColorsPage.builder().setElements("Fire").setColor("Blue")
                        .setVegetables("Cucumber", "Tomato", "Vegetables").build()}
        };
    }

    @Test(dataProvider = "metalsAndColorsPageDataProvider")
    public void checkMetalsAndColorsPageUIElements(DataForMetalsAndColorsPage dataForMetalsAndColorsPage) {
        IndexPage indexPage = new IndexPage(driver);

        // 2. Perform login
        // 3. Click on the link on the Header section
        indexPage.login(resourceProperty.getValue("login"), resourceProperty.getValue("password"))
                .clickHeaderMenuItem("METALS & COLORS");

        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage(driver);

        // 4. Fill form on the page
        // 5. Click “Submit” button
        List<String> actualResult = metalsAndColorsPage
                .clickRadiosToSumm(dataForMetalsAndColorsPage.getA(), dataForMetalsAndColorsPage.getB())
                .clickElementsCheckboxes(dataForMetalsAndColorsPage.getElements())
                .selectColor(dataForMetalsAndColorsPage.getColor())
                .selectMetal(dataForMetalsAndColorsPage.getMetal())
                .selectVegetables(dataForMetalsAndColorsPage.getVegetables())
                .clickSubmitButton()
                .getResults();

        // 6. Check Results block output on the right-side
        assertTrue(actualResult.containsAll(dataForMetalsAndColorsPage.getNonDefaultResultStrings()));

    }
}
