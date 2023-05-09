package com.epam.ui.helpers;

import com.codeborne.selenide.Condition;
import com.epam.ui.BasePage;
import com.epam.ui.pages.LaunchesPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import lombok.extern.log4j.Log4j2;

import static com.epam.data.Constants.waiter;

@Log4j2
public class LaunchesPageHelper extends BasePage {

    public static LaunchesPage launchesPage = new LaunchesPage();

    public static void clickOnLaunches() {
        log.info("click on launches tab in the hamburger menu");
        launchesPage.getLaunchesTab().click();
        waiter.until(o -> o.getCurrentUrl().contains("/launches"));
        waiter.until(ExpectedConditions.visibilityOfAllElements(launchesPage.getLaunchName()));
    }

    public static void clickOnAddFilter() {
        log.info("click on Add new filter");
        launchesPage.getAddFilter().click();
    }

    public static void clickOnDeleteFilter() {
        log.info("delete last added filter");
        launchesPage.getDeleteFilter().click();
    }

    public static void clickOnSorting(String filterName) {
        log.info("sort launches by failures");
        launchesPage.sortingBy(filterName).click();
    }

    public static void filtersHasItems(int amountFilters) {
        log.info("verify that list of filter has exact amount of them");
        Assert.assertEquals(launchesPage.getAddedFilter().size(), amountFilters);
    }

    public static void firstLaunchFilters(String filterName) {
        log.info("verify that list of filter has exact amount of them");
        launchesPage.getFirstLaunchFilterTestsAmount(filterName).shouldBe(Condition.empty);
    }
}
