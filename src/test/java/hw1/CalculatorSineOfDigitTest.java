package hw1;

import com.epam.tat.module4.Calculator;
import org.decimal4j.util.DoubleRounder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSineOfDigitTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp(){
        calculator = new Calculator();
    }

    @DataProvider
    public Object[][] sinDigitsDataProvider(){
        return new Object[][]{
                {90, 1},
                {30, 0.5}
        };
    }

    @Test(dataProvider = "sinDigitsDataProvider")
    public void sinDigits(double a, double expected){
        assertEquals(DoubleRounder.round(calculator.sin(Math.toRadians(a)), 1), expected);
    }

    @AfterMethod
    public void tearDown(){
        calculator = null;
    }
}
