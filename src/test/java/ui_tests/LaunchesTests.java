package ui_tests;

import org.testng.annotations.Test;

public class LaunchesTests extends BaseTest {

    @Test(description = "Add and delete filter")
    public void workingWithFilters() {
        launchesPage.clickOnLaunches();
        launchesPage.filtersHasItems(1);
        launchesPage.clickOnAddFilter();
        launchesPage.filtersHasItems(2);
        launchesPage.clickOnDeleteFilter();
        launchesPage.filtersHasItems(1);
    }

    @Test(description = "First test has no failures")
    public void firstLaunchHasNoFailures() {
        launchesPage.clickOnLaunches();
        launchesPage.clickOnSorting("fl");
        launchesPage.firstLaunchFilters("failed");
    }

    @Test(description = "Sorting", dataProvider = "filterByFailures")
    public void filterByFilters(String sortingName, String filterName) {
        launchesPage.clickOnLaunches();
        launchesPage.clickOnSorting(sortingName);
        launchesPage.firstLaunchFilters(filterName);
    }
}
