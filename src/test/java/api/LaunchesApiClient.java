package api;

import com.google.gson.Gson;
import api.models.launches.ResponseForLaunches;
import api.models.launches.put.ResponsePutDescription;

import io.restassured.response.Response;

import static api.endpoints.LaunchesApi.LAUNCHES;

public class LaunchesApiClient extends ApiBaseTest {

    public static int getLaunchID() {
        Gson gson = new Gson();
        Response response = ClientApiHelper.auth().when().get(props.getProperty("login.url") + LAUNCHES);
        ResponseForLaunches responseForLaunches = gson.fromJson(response.getBody().print(),
                ResponseForLaunches.class
        );
        return responseForLaunches.getContent().get(responseForLaunches.getContent().size() - 1).getId();
    }

    public static String updateLaunch(int launchID) {
        ResponsePutDescription responseFromPojo = ResponsePutDescription.builder().description("test desc")
                .build();
        Response response = ClientApiHelper.auth().body(responseFromPojo).when().put(
                props.getProperty("login.url") + LAUNCHES + launchID + "/update").then().extract().response();
        return response.jsonPath().get("message");
    }

    public static String deleteLaunch(int launchID) {
        Response response = ClientApiHelper.auth().when().delete(
                props.getProperty("login.url") + LAUNCHES + launchID).then().extract().response();
        return response.jsonPath().get("message");
    }
}
