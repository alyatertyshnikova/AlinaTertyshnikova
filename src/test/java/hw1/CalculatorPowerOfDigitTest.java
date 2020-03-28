package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowerOfDigitTest extends AbstractBaseTest{

    @DataProvider
    public Object[][] powDigitsDataProvider(){
        return new Object[][]{
                {3, 2, 9},
                {123, 0, 1},
                {2, -1, 0.5},
        };
    }

    @Test (dataProvider = "powDigitsDataProvider")
    public void powDigits(double a, double b, double expected){
        assertEquals(calculator.pow(a, b), expected);
    }

}
