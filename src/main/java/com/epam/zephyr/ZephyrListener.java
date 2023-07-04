package com.epam.zephyr;

import com.epam.api.JiraApiClient;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import lombok.SneakyThrows;

public class ZephyrListener implements TestWatcher {

    public static final String PARTIAL_TEST_ID = "AUT-T";
    public static final String PASS = "Pass";
    public static final String FAIL = "Fail";
    private final JiraApiClient jira = new JiraApiClient();

    @SneakyThrows
    @Override
    public void testSuccessful(ExtensionContext context) {
        jira.updateTestExecutionStatus(getTestId(context), PASS);
    }

    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        jira.updateTestExecutionStatus(getTestId(context), FAIL);
    }

    private static String getTestId(ExtensionContext context) throws NoSuchFieldException {
        return context.getTags().stream().filter(tag -> tag.contains(PARTIAL_TEST_ID)).findFirst()
                .orElseThrow(NoSuchFieldException::new);
    }
}