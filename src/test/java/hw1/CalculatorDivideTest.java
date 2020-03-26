package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] divideDigitsDataProvider() {
        return new Object[][]{
                {6, 2, 3},
                {137, 1, 137},
                {2, 0.5, 4},
                {45, -9, -5},
                {342, 0, Double.POSITIVE_INFINITY}
        };
    }

    @Test(dataProvider = "divideDigitsDataProvider", groups = {"multiplyAndDivide"})
    public void divideDigits(double a, double b, double expected) {
        assertEquals(calculator.div(a, b), expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
