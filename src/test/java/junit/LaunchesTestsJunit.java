package junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LaunchesTestsJunit extends BaseTest {

    @ParameterizedTest
    @DisplayName("Test for sorting")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void filterByFilters(String sortingName, String filterName) {
        utilitySteps.login();
        launchesPage.clickOnLaunches();
        launchesPage.clickOnSorting(sortingName);
        launchesPage.firstLaunchFilters(filterName);
    }
}
