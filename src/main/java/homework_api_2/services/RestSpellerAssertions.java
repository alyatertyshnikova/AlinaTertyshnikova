package homework_api_2.services;

import homework_api_2.dto.ErrorDto;

import static org.testng.Assert.assertEquals;

public class RestSpellerAssertions {

    private ErrorDto[] errors;

    public RestSpellerAssertions(ErrorDto[] errors) {
        this.errors = errors;
    }

    public void checkErrorSize(int expectedErrorLength) {
        assertEquals(errors.length, expectedErrorLength);
    }
}
