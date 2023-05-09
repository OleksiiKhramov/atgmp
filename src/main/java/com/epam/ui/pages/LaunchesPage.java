package com.epam.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.ui.BasePage;
import org.openqa.selenium.By;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Log4j2
@Getter
@NoArgsConstructor
public class LaunchesPage extends BasePage {

    private SelenideElement launchesTab = $(By.cssSelector("a[href*='launches']"));
    private SelenideElement addFilter = $(By.xpath("//span[contains(text(),'Add filter')]"));
    private SelenideElement launchName = $(By.xpath("//td[contains(@class,'launchSuiteGrid__name')]"));
    private SelenideElement deleteFilter = $(By.cssSelector("div[class*='filterItem__icon']"));
    private List<SelenideElement> addedFilter = $$(By.cssSelector("span[class*='filterItem__name']"));
    private String sortBy = "//span[contains(@class,'headerCell') and contains(text(),'%s')]";
    private String firstLaunchFilterTestsAmount = "//span[contains(text(),'%s')]/ancestor::div[contains(@class,'executionStatistics__execution-statistics')][1]";

    public SelenideElement getFirstLaunchFilterTestsAmount(String filterName) {
        return $(By.xpath(String.format(firstLaunchFilterTestsAmount, filterName)));
    }

    public SelenideElement sortingBy(String filterName) {
        return $(By.xpath(String.format(sortBy, filterName)));
    }
}