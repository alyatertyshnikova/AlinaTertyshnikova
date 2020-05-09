package homework_api_2.services;

import homework_api_2.ResourceManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class CommonService {
    private RequestSpecification REQUEST_SPECIFICATION;

    public CommonService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(ResourceManager.getTestProperty("domain"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        return RestAssured
                .given(REQUEST_SPECIFICATION)
                .params(params)
                .when()
                .get(uri);
    }
}
