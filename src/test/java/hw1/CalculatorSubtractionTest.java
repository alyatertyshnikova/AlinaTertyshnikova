package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractionTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] subDigitsDataProvider() {
        return new Object[][]{
                {5, 3, 2},
                {3, 5, -2},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "subDigitsDataProvider", groups = {"addAndSubtract"})
    public void subDigits(double a, double b, double expected) {
        assertEquals(calculator.sub(a, b), expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
