package homework_api_2.services;

import homework_api_2.ResourceManager;
import homework_api_2.dto.WordDto;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonService {
    private RequestSpecification REQUEST_SPECIFICATION;

    public CommonService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(ResourceManager.getTestProperties().get("domain").toString())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response get(String uri, WordDto wordDto) {
        return RestAssured
                .given(REQUEST_SPECIFICATION)
                .param("text", wordDto.getWordWithError())
                .param("lang", wordDto.getLang())
                .param("options", wordDto.getOptions())
                .when()
                .get(uri);
    }
}
