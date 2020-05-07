package homework_api_2;

import homework_api_2.dto.ErrorDto;
import homework_api_2.dto.WordDto;
import homework_api_2.services.RestSpellerService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ErrorAttributesDefinitionTest {
    private static final String TEST_STRING = "good\nmoning";
    private static final int EXPECTED_POSITION = 5;
    private static final int EXPECTED_ROW = 1;
    private static final int EXPECTED_CODE = 1;
    private ErrorDto[] errors;

    @BeforeClass
    public void setUp() {
        errors = new RestSpellerService().getCheckTextResult(new WordDto().setWordWithError(TEST_STRING));
    }

    @Test
    public void checkErrorPosition() {
        assertEquals(errors[0].getPos(), EXPECTED_POSITION);
    }

    @Test
    public void checkErrorRow() {
        assertEquals(errors[0].getRow(), EXPECTED_ROW);
    }

    @Test
    public void checkErrorCode() {
        assertEquals(errors[0].getCode(), EXPECTED_CODE);
    }
}
