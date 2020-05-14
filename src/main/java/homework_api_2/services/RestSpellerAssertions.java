package homework_api_2.services;

import homework_api_2.dto.ErrorDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

public class RestSpellerAssertions {

    private ErrorDto[] errors;

    public RestSpellerAssertions(ErrorDto[] errors) {
        this.errors = errors;
    }

    public RestSpellerAssertions checkErrorSize(int expectedErrorLength) {
        assertEquals(errors.length, expectedErrorLength);
        return this;
    }

    public RestSpellerAssertions checkErrorAttributes(String wordWithError, ErrorDto expectedError) {
        assertThat(errors).filteredOn(error -> error.getWord().contains(wordWithError))
                .usingElementComparatorOnFields("code", "pos", "row")
                .contains(expectedError);
        return this;
    }

    public RestSpellerAssertions checkResponseContainCorrectWord(List<String> correctWord) {
        assertThat(errors).flatExtracting(ErrorDto::getS).containsAll(correctWord);
        return this;
    }

    public RestSpellerAssertions checkWordWithError(String wordWithError) {
        assertThat(errors).extracting(ErrorDto::getWord).contains(wordWithError);
        return this;
    }
}
