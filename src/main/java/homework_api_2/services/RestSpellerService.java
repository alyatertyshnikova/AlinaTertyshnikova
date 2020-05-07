package homework_api_2.services;

import homework_api_2.dto.ErrorDto;
import homework_api_2.dto.WordDto;

public class RestSpellerService {

    private static final String CHECK_TEXT_URI = "/services/spellservice.json/checkText";

    public ErrorDto[] getCheckTextResult(WordDto wordDto) {
        return new CommonService()
                .get(CHECK_TEXT_URI, wordDto)
                .getBody()
                .as(ErrorDto[].class);
    }
}
