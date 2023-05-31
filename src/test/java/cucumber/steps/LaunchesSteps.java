package cucumber.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.data.ResourcesReader;
import com.epam.ui.helpers.UtilitySteps;
import com.epam.ui.pages.LaunchesPage;
import com.epam.ui.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.data.Constants.FILE_PATH;
import static com.epam.data.Constants.waiter;

@Slf4j
public class LaunchesSteps {

    ResourcesReader resourcesReader = new ResourcesReader();
    Properties props = resourcesReader.loadPropertiesFile(FILE_PATH);
    LaunchesPage launchesPage = new LaunchesPage();
    LoginPage loginPage = new LoginPage();
    UtilitySteps utilitySteps = new UtilitySteps();

    @Before
    public void beforeScenario() {
        Configuration.browser = (props.getProperty("browser.type"));
        loginPage.setBaseUrl(props.getProperty("login.url"));
    }

    @After
    public void afterScenario() {
        WebDriverRunner.closeWebDriver();
    }

    @Given("open ReportPortal")
    public void openReportPortal() {
        loginPage.open();
        utilitySteps.login();
    }

    @And("click on launches tab")
    public void clickOnLaunches() {
        log.info("click on launches tab in the hamburger menu");
        launchesPage.getLaunchesTab().click();
        waiter.until(ExpectedConditions.visibilityOfAllElements(launchesPage.getLaunchName()));
    }

    @When("click on add new filter")
    public void clickOnAddFilter() {
        log.info("click on Add new filter");
        launchesPage.getAddFilter().click();
    }

    @When("click on delete last added filter")
    public void clickOnDeleteFilter() {
        log.info("delete last added filter");
        launchesPage.getDeleteFilter().click();
    }

    @And("click on sorting \"([^\"]*)\"$")
    public void clickOnSorting(String filterName) {
        log.info("sort launches by failures");
        launchesPage.sortingBy(filterName).click();
    }

    @Then("filter has (\\d+) (?:item|items)$")
    public void filtersHasItems(int amountFilters) {
        log.info("verify that list of filter has exact amount of them");
        Assert.assertEquals(launchesPage.getAddedFilter().size(), amountFilters);
    }

    @Then("first launch sorted by \"([^\"]*)\"$")
    public void firstLaunchFilters(String filterName) {
        log.info("verify sorting");
        launchesPage.getFirstLaunchFilterTestsAmount(filterName).shouldBe(Condition.empty);
    }
}
