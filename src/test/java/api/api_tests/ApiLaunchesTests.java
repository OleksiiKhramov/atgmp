package api.api_tests;

import org.junit.jupiter.api.Tag;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.clients.LaunchesApiClient;
import api.utils.ClientApiHelper;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.qameta.allure.Description;
import io.restassured.response.Response;

import static api.api_tests.ApiConstants.LAUNCHES;
import static api.api_tests.ApiConstants.props;

public class ApiLaunchesTests {

    private static LaunchesApiClient launchesApiClient = new LaunchesApiClient();

    @Test
    @Description("api test")
    @Tag("api")
    public static void getLaunches() {
        Response response = ClientApiHelper.auth().when().get(props.getProperty("login.url") + LAUNCHES);
        response.getBody().print();
    }

    @Test
    @Description("import launch from file")
    @Tag("api")
    public static void postLaunchFromFile() {
        File file = new File("src/test/java/resources/RP_LAUNCH_XLS_Report.zip");
        Response response = ClientApiHelper.authForFileUploading().multiPart(file).when().post(
                props.getProperty("login.url") + LAUNCHES + "import");
        Pattern pattern = Pattern.compile("([A-Za-z0-9]+(-[A-Za-z0-9]+)+)");
        Matcher matcher = pattern.matcher(response.jsonPath().get("message"));
        Assert.assertTrue(matcher.find());
        Assert.assertEquals(response.jsonPath().get("message"),
                "Launch with id = " + matcher.group(1) + " is successfully imported."
        );
    }

    @Test
    @Description("update name and delete launch")
    @Tag("api")
    public static void updateAndDeleteLaunch() {
        int id = launchesApiClient.getLaunchID();
        Assert.assertEquals(launchesApiClient.updateLaunch(id),
                "Launch with ID = '" + id + "' successfully updated."
        );
        Assert.assertEquals(launchesApiClient.deleteLaunch(id),
                "Launch with ID = '" + id + "' successfully deleted."
        );
    }
}
