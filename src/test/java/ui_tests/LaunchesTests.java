package ui_tests;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
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

    @Test(description = "resizing")
    public void resizeWidgetOnDashboardPage() {
        dashboardPage.clickOnDashboards();
        dashboardPage.clickOnFirstDashboard();
        Dimension beforeChanges = dashboardPage.getFirstWidget().getSize();
        dashboardPage.resizeWidget(dashboardPage.getWidgetResizeButton(dashboardPage.getFirstWidget()), -75,
                0
        );
        Dimension afterChanges = dashboardPage.getFirstWidget().getSize();
        Assert.assertTrue(beforeChanges.getWidth() > afterChanges.getWidth(),
                String.format("Size before changes: %s, %d. Size after changes: %s, %d.",
                        beforeChanges.getWidth(), beforeChanges.getHeight(), afterChanges.getWidth(),
                        afterChanges.getHeight()
                )
        );
        dashboardPage.resizeWidget(dashboardPage.getWidgetResizeButton(dashboardPage.getFirstWidget()), 75,
                0
        );
        Dimension afterSecondChange = dashboardPage.getFirstWidget().getSize();
        Assert.assertEquals(beforeChanges.getWidth(), afterSecondChange.getWidth(),
                String.format("Size before changes: %s, %d. Size after second change: %s, %d.",
                        beforeChanges.getWidth(), beforeChanges.getHeight(), afterSecondChange.getWidth(),
                        afterSecondChange.getHeight()
                )
        );
    }
}
