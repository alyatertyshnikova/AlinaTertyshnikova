package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSineOfDigitTest extends AbstractBaseTest{

    @DataProvider
    public Object[][] sinDigitsDataProvider(){
        return new Object[][]{
                {90, 1},
                {30, 0.5},
                {180, 0}
        };
    }

    @Test(dataProvider = "sinDigitsDataProvider")
    public void sinDigits(double a, double expected){
        assertEquals(calculator.sin(Math.toRadians(a)), expected, 0.00001);
    }

}
