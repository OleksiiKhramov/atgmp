package com.epam.ui;

import com.codeborne.selenide.Selenide;
import com.epam.data.ResourcesReader;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

import static com.epam.data.Constants.FILE_PATH;

@Slf4j
public class BasePage {

    public static ResourcesReader resourcesReader = new ResourcesReader();
    public static Properties props = resourcesReader.loadPropertiesFile(FILE_PATH);
    private String baseUrl;

    public BasePage open() {
        Selenide.open(this.baseUrl);
        return this;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        log.info("Set baseUrl to: '" + this.baseUrl + "'");
    }
}
