package com.epam.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestApiClient {

    public Response postRequest(String baseUrl, String endPoint, String authToken, Object body) {
        return given().baseUri(baseUrl).header("Authorization", "Bearer ".concat(authToken)).contentType(
                ContentType.JSON).when().body(body).post(endPoint);
    }
}
