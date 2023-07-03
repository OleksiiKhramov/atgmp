package com.epam.data;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
@NoArgsConstructor
public class ResourcesReader {

    public Properties loadPropertiesFile(String filePath) {

        Properties properties = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            log.error("Unable to load properties file : " + filePath);
        }
        return properties;
    }
}
