package api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static api.entities.Login.bearerToken;
import static io.restassured.RestAssured.given;

public class ClientApiHelper {

    public static RequestSpecification auth() {
        RequestSpecification spec = given().headers("Authorization", "Bearer " + bearerToken, "Content-Type",
                ContentType.JSON, "Accept", ContentType.JSON
        );
        return spec;
    }

    public static RequestSpecification authForFileUploading() {
        RequestSpecification spec = given().headers("Authorization", "Bearer " + bearerToken, "Content-Type",
                ContentType.MULTIPART, "Accept", ContentType.JSON
        );
        return spec;
    }
}
