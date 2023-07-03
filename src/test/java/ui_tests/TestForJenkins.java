package ui_tests;

import org.testng.annotations.Test;

public class TestForJenkins extends BaseTest {

    @Test(description = "TestForJenkins")
    public void testForJenkins() {
        launchesPage.clickOnLaunches();
        launchesPage.clickOnSorting("fl");
        launchesPage.firstLaunchFilters("failed");
    }
}
