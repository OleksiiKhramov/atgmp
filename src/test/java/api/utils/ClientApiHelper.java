package api.utils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static api.api_tests.ApiConstants.BEARER_TOKEN;
import static io.restassured.RestAssured.given;

public class ClientApiHelper {

    public static RequestSpecification auth() {
        String bearerToken;
        RequestSpecification spec = given().headers("Authorization", "Bearer " + BEARER_TOKEN, "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON
        );
        return spec;
    }

    public static RequestSpecification authForFileUploading() {
        RequestSpecification spec = given().headers("Authorization", "Bearer " + BEARER_TOKEN, "Content-Type",
                ContentType.MULTIPART, "Accept", ContentType.JSON
        );
        return spec;
    }
}
