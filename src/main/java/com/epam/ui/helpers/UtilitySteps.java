package com.epam.ui.helpers;

import com.epam.ui.pages.LoginPage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UtilitySteps {

    LoginPage loginPage = new LoginPage();

    public void login() {
        log.info("login");
        loginPage.inputUsername();
        loginPage.inputPassword();
        loginPage.getSubmitButton().click();
    }
}
