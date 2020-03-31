package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorIsNegativeTest extends AbstractBaseTest {

    @DataProvider
    public Object[][] isDigitNegativeDataProvider() {
        return new Object[][]{
                {-1, true},
                {-100, true},
                {0, false},
                {5000, false}
        };
    }

    @Test(dataProvider = "isDigitNegativeDataProvider")
    public void isDigitNegative(long val, boolean expected) {
        assertEquals(calculator.isNegative(val), expected);
    }

}
