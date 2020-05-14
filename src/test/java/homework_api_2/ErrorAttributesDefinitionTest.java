package homework_api_2;

import homework_api_2.dto.ErrorDto;
import homework_api_2.dto.WordDto;
import homework_api_2.services.RestSpellerAssertions;
import homework_api_2.services.RestSpellerService;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;

public class ErrorAttributesDefinitionTest {
    private static final WordDto TEST_TEXT = new WordDto().setWordWithError(asList("good\nmoning"));
    private static final ErrorDto EXPECTED_ERROR = new ErrorDto().setCode(1).setPos(5).setRow(1);
    private static final String WORD_WITH_ERROR = "moning";

    @Test
    public void checkErrorAttributes() {
        ErrorDto[] errors = new RestSpellerService().getCheckTextResult(TEST_TEXT);
        new RestSpellerAssertions(errors).checkErrorAttributes(WORD_WITH_ERROR, EXPECTED_ERROR);
    }
}
