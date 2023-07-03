package com.epam.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.epam.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.epam.data.Constants.waiter;

@Log4j2
@Getter
@NoArgsConstructor
public class LaunchesPage extends BasePage {

    private SelenideElement launchesTab = $(By.cssSelector("a[href*='launches']"));
    private SelenideElement addFilter = $(By.xpath("//span[contains(text(),'Add filter')]"));
    private SelenideElement launchName = $(By.xpath("//td[contains(@class,'launchSuiteGrid__name')]"));
    private SelenideElement deleteFilter = $(By.cssSelector("div[class*='filterItem__icon']"));
    private List<SelenideElement> addedFilter = $$(By.cssSelector("span[class*='filterItem__name']"));
    private String sortBy = "//span[contains(@class,'headerCell') and contains(text(),'%s')]/..";
    private String firstLaunchFilterTestsAmount = "//span[contains(text(),'%s')]/ancestor::div[contains(@class,'executionStatistics__execution-statistics')][1]";

    public SelenideElement getFirstLaunchFilterTestsAmount(String filterName) {
        return $(By.xpath(String.format(firstLaunchFilterTestsAmount, filterName)));
    }

    public SelenideElement sortingBy(String filterName) {
        return $(By.xpath(String.format(sortBy, filterName)));
    }

    public void clickOnLaunches() {
        log.info("click on launches tab in the hamburger menu");
        getLaunchesTab().click();
        waiter.until(ExpectedConditions.visibilityOfAllElements(getLaunchName()));
    }

    public void clickOnAddFilter() {
        log.info("click on Add new filter");
        getAddFilter().click();
    }

    public void clickOnDeleteFilter() {
        log.info("delete last added filter");
        getDeleteFilter().click();
    }

    public void clickOnSorting(String filterName) {
        log.info("sort launches by failures");
        sortingBy(filterName).click();
    }

    public void filtersHasItems(int amountFilters) {
        log.info("verify that list of filter has exact amount of them");
        Assert.assertEquals(getAddedFilter().size(), amountFilters);
    }

    public void firstLaunchFilters(String filterName) {
        log.info("verify that list of filter has exact amount of them");
        getFirstLaunchFilterTestsAmount(filterName).shouldBe(Condition.empty);
    }
}