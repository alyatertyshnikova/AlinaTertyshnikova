package homework_api_2.services;

import homework_api_2.dto.ErrorDto;
import homework_api_2.dto.WordDto;

public class RestSpellerService {

    public ErrorDto[] getCheckTextResult(WordDto wordDto) {
        return new CommonService()
                .getWithParams(URI.CHECK_TEXT_URI, wordDto.toParamsMap())
                .getBody()
                .as(ErrorDto[].class);
    }

    public ErrorDto[][] getCheckTextsResult(WordDto wordDto) {
        return new CommonService()
                .getWithParams(URI.CHECK_TEXTS_URI, wordDto.toParamsMap())
                .getBody()
                .as(ErrorDto[][].class);
    }
}
