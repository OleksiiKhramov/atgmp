package com.epam.data;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.WebDriverWait;
import lombok.Getter;

import java.time.Duration;

@Getter
public class Constants {

    public static final String FILE_PATH = "config.properties";
    public static WebDriverWait waiter = new WebDriverWait(WebDriverRunner.getWebDriver(),
            Duration.ofSeconds(1)
    );
}
