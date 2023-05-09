package cucumber.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.epam.ui.pages.LaunchesPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import lombok.extern.slf4j.Slf4j;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.epam.data.Constants.waiter;
import static com.epam.ui.BasePage.props;
import static com.epam.ui.helpers.LoginPageHelper.login;
import static com.epam.ui.helpers.LoginPageHelper.loginPage;

@Slf4j
public class LaunchesSteps {

    public static LaunchesPage launchesPage = new LaunchesPage();

    @Given("open ReportPortal")
    public void openReportPortal() {
        Configuration.browser = (props.getProperty("browser.type"));
        loginPage.setBaseUrl(props.getProperty("login.url"));
        loginPage.open();
        login();
    }

    @And("click on launches tab")
    public void clickOnLaunches() {
        log.info("click on launches tab in the hamburger menu");
        launchesPage.getLaunchesTab().click();
        waiter.until(o -> o.getCurrentUrl().contains("/launches"));
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
