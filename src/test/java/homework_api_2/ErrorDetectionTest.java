package homework_api_2;

import homework_api_2.dto.ErrorDto;
import homework_api_2.dto.WordDto;
import homework_api_2.services.RestSpellerAssertions;
import homework_api_2.services.RestSpellerService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;

public class ErrorDetectionTest {
    private static final String ERROR_IN_TEXT_WITH_OPTIONS = "на";

    private static final WordDto TEXT_WITH_OPTIONS = new WordDto()
            .setWordWithError(asList("Я еду на на Кипр. Зайди на сайт www.site.ru - User1"))
            .setOptions(526);
    private static final WordDto TEXT_IN_UNKNOWN_LANGUAGE = new WordDto()
            .setWordWithError(asList("გამარჯობ"));
    private static final WordDto TEXTS = new WordDto()
            .setWordWithError(asList("helo", "warld"))
            .setCorrectWord(asList("hello", "world"));

    @DataProvider
    public Object[] checkTextInDifferentLanguagesDataProvider() {
        return new WordDto[]{
                new WordDto().setWordWithError(asList("превед")).setLang("ru").setCorrectWord(asList("привет")),
                new WordDto().setWordWithError(asList("helo")).setLang("en").setCorrectWord(asList("hello")),
                new WordDto().setWordWithError(asList("вiтаня")).setLang("uk").setCorrectWord(asList("вітання"))
        };
    }

    @Test
    public void checkOptions() {
        ErrorDto[] errors = new RestSpellerService()
                .getCheckTextResult(TEXT_WITH_OPTIONS);
        new RestSpellerAssertions(errors)
                .checkErrorSize(1)
                .checkWordWithError(ERROR_IN_TEXT_WITH_OPTIONS);
    }

    @Test
    public void checkUnknownLanguage() {
        ErrorDto[] errors = new RestSpellerService()
                .getCheckTextResult(TEXT_IN_UNKNOWN_LANGUAGE);
        new RestSpellerAssertions(errors).checkErrorSize(0);
    }

    @Test(dataProvider = "checkTextInDifferentLanguagesDataProvider")
    public void checkTextInDifferentLanguages(WordDto wordDto) {
        ErrorDto[] errors = new RestSpellerService().getCheckTextResult(wordDto);
        new RestSpellerAssertions(errors).checkResponseContainCorrectWord(wordDto.getCorrectWord());
    }

    @Test
    public void checkTexts() {
        ErrorDto[][] errors = new RestSpellerService().getCheckTextsResult(TEXTS);
        ErrorDto[] errorDto = Arrays.stream(errors).flatMap(Arrays::stream).toArray(ErrorDto[]::new);
        new RestSpellerAssertions(errorDto).checkResponseContainCorrectWord(TEXTS.getCorrectWord());
    }
}
