package com.epam.zephyr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZephyrBody {

    private String projectKey;
    private String testCaseKey;
    private String testCycleKey;
    private String statusName;

    public static ZephyrBody testExecBody(String testCaseKey, String statusName) {
        return ZephyrBody.builder().projectKey("AUT").testCaseKey(testCaseKey).testCycleKey("AUT-R1")
                .statusName(statusName).build();
    }
}