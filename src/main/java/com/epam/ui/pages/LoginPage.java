package com.epam.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.epam.ui.BasePage;
import org.openqa.selenium.By;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
@Getter
@NoArgsConstructor
public class LoginPage extends BasePage {

    private SelenideElement userName = $(By.name("login"));
    private SelenideElement password = $(By.name("password"));
    private SelenideElement submitButton = $(By.xpath("//button[@type='submit']"));

    public void inputUsername() {
        log.info("input username step");
        getUserName().clear();
        getUserName().sendKeys(props.getProperty("user.username"));
    }

    public void inputPassword() {
        log.info("input password step");
        getPassword().clear();
        getPassword().sendKeys(props.getProperty("user.password"));
    }
}