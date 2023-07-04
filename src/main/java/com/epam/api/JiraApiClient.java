package com.epam.api;

import com.epam.data.ResourcesReader;
import com.epam.zephyr.ZephyrBody;
import lombok.extern.log4j.Log4j2;

import java.util.Properties;

import static com.epam.data.Constants.FILE_PATH;

@Log4j2
public class JiraApiClient {

    private final RestApiClient restApiClient = new RestApiClient();
    ResourcesReader resourcesReader = new ResourcesReader();
    Properties props = resourcesReader.loadPropertiesFile(FILE_PATH);

    public void updateTestExecutionStatus(String testCaseId, String status) {
        ZephyrBody body = ZephyrBody.testExecBody(testCaseId, status);
        log.info(String.format("Updating execution Status for %s to %s", testCaseId, status));
        restApiClient.postRequest(props.getProperty("base.url"), "testexecutions",
                props.getProperty("auth.token"), body
        ).prettyPrint();
    }
}