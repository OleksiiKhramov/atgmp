package junit;

import com.epam.zephyr.ZephyrListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(ZephyrListener.class)
public class LaunchesTestsJunit extends BaseTest {

    @ParameterizedTest
    @DisplayName("Test for sorting")
    @Tag("AUT-T1")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    public void filterByFilters(String sortingName, String filterName) {
        commonSteps.login();
        launchesPage.clickOnLaunches();
        launchesPage.clickOnSorting(sortingName);
        launchesPage.firstLaunchFilters(filterName);
    }
}
