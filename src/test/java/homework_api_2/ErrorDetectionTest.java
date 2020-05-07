package homework_api_2;

import homework_api_2.dto.ErrorDto;
import homework_api_2.dto.WordDto;
import homework_api_2.services.RestSpellerAssertions;
import homework_api_2.services.RestSpellerService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ErrorDetectionTest {
    private static final String TEST_OPTIONS_STRING = "Я еду на на Кипр. Зайди на сайт www.site.ru - User1";
    private static final String EXPECTED_ERROR_IN_TEST_STRING = "на";
    private static final String UNKNOWN_LANGUAGE_WORD = "გამარჯობ";
    private static final int OPTIONS = 526;

    @DataProvider
    public Object[] checkTextsInDifferentLanguagesDataProvider() {
        return ResourceManager.getObjectsFromJson(
                ResourceManager.getTestProperties().get("testDataFile").toString(),
                WordDto[].class
        );
    }

    @Test
    public void checkOptions() {
        ErrorDto[] errors = new RestSpellerService()
                .getCheckTextResult(new WordDto().setWordWithError(TEST_OPTIONS_STRING).setOptions(OPTIONS));
        new RestSpellerAssertions(errors).checkErrorSize(1);
        assertThat(errors[0].getWord()).isEqualTo(EXPECTED_ERROR_IN_TEST_STRING);
    }

    @Test
    public void checkUnknownLanguage() {
        ErrorDto[] errors = new RestSpellerService().getCheckTextResult(new WordDto().setWordWithError(UNKNOWN_LANGUAGE_WORD));
        new RestSpellerAssertions(errors).checkErrorSize(0);
    }

    @Test(dataProvider = "checkTextsInDifferentLanguagesDataProvider")
    public void checkTextsInDifferentLanguages(WordDto wordDto) {
        ErrorDto[] errors = new RestSpellerService().getCheckTextResult(wordDto);
        assertThat(errors[0].getS()).contains(wordDto.getCorrectWord());
    }
}
