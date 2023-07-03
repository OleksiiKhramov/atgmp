package com.epam.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.epam.ui.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
public class DashboardPage extends BasePage {

    private SelenideElement dashboardTab = $(By.cssSelector("a[href*='dashboard']"));
    private List<SelenideElement> dashboards = $$(By.cssSelector("[class*='dashboardTable__name']"));
    private List<SelenideElement> widgets = $$(By.cssSelector("[class*=react-grid-item]"));

    public void clickOnDashboards() {
        log.info("click on dashboard tab in the hamburger menu");
        getDashboardTab().click();
        waiter.until(ExpectedConditions.visibilityOfAllElements(getDashboards().get(0)));
    }

    public void clickOnFirstDashboard() {
        log.info("select first dashboard");
        getDashboards().get(0).click();
        waiter.until(ExpectedConditions.visibilityOfAllElements(getWidgets().get(0)));
    }

    public SelenideElement getFirstWidget() {
        log.info("get first dashboard element");
        SelenideElement widget = widgets.get(0);
        widget.shouldBe(Condition.visible);
        return widget;
    }

    public SelenideElement getWidgetResizeButton(SelenideElement selenideElement) {
        log.info("return resize button");
        return selenideElement.$(By.cssSelector("[class*=resizable-handle]"));
    }

    public void resizeWidget(SelenideElement element, int x, int y) {
        log.info("resize element");
        Selenide.actions().dragAndDropBy(element, x, y).perform();
    }
}
