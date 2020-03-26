package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest {

    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] multiplyDigitsDataProvider() {
        return new Object[][]{
                {2, 2, 4},
                {50, 0, 0},
                {5, -10, -50}
        };
    }


    @Test(dataProvider = "multiplyDigitsDataProvider", groups = {"multiplyAndDivide"})
    public void multiplyDigits(double a, double b, double expected) {
        assertEquals(calculator.mult(a, b), expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
