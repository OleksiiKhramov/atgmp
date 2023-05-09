package com.epam.ui.helpers;

import com.epam.ui.BasePage;
import com.epam.ui.pages.LoginPage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginPageHelper extends BasePage {

    public static LoginPage loginPage = new LoginPage();

    public static void inputUsername() {
        log.info("input username step");
        loginPage.getUserName().clear();
        loginPage.getUserName().sendKeys(props.getProperty("user.username"));
    }

    public static void inputPassword() {
        log.info("input password step");
        loginPage.getPassword().clear();
        loginPage.getPassword().sendKeys(props.getProperty("user.password"));
    }

    public static void login() {
        log.info("login");
        inputUsername();
        inputPassword();
        loginPage.getSubmitButton().click();
    }
}
