package com.epam.ui.steps;

import com.epam.ui.pages.LoginPage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommonSteps {

    LoginPage loginPage = new LoginPage();

    public void login() {
        log.info("login");
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.getSubmitButton().click();
    }
}
