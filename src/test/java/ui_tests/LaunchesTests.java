package ui_tests;

import com.epam.ui.helpers.LaunchesPageHelper;
import org.testng.annotations.Test;

public class LaunchesTests extends BaseTest {

    @Test(description = "Add and delete filter")
    public void workingWithFilters() {
        LaunchesPageHelper.clickOnLaunches();
        LaunchesPageHelper.filtersHasItems(1);
        LaunchesPageHelper.clickOnAddFilter();
        LaunchesPageHelper.filtersHasItems(2);
        LaunchesPageHelper.clickOnDeleteFilter();
        LaunchesPageHelper.filtersHasItems(1);
    }

    @Test(description = "First test has no failures")
    public void firstLaunchHasNoFailures() {
        LaunchesPageHelper.clickOnLaunches();
        LaunchesPageHelper.clickOnSorting("fl");
        LaunchesPageHelper.firstLaunchFilters("failed");
    }

    @Test(description = "Sorting", dataProvider = "filterByFailures")
    public void filterByFilters(String sortingName, String filterName) {
        LaunchesPageHelper.clickOnLaunches();
        LaunchesPageHelper.clickOnSorting(sortingName);
        LaunchesPageHelper.firstLaunchFilters(filterName);
    }
}
