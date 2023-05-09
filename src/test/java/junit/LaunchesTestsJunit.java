package junit;

import com.epam.ui.helpers.LaunchesPageHelper;
import com.epam.ui.helpers.LoginPageHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LaunchesTestsJunit extends BaseTest {

    @ParameterizedTest
    @DisplayName("Test for sorting")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void filterByFilters(String sortingName, String filterName) {
        LoginPageHelper.login();
        LaunchesPageHelper.clickOnLaunches();
        LaunchesPageHelper.clickOnSorting(sortingName);
        LaunchesPageHelper.firstLaunchFilters(filterName);
    }
}
