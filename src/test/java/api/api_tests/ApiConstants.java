package api.api_tests;

import com.epam.data.ResourcesReader;

import java.util.Properties;

import static com.epam.data.Constants.FILE_PATH;

public class ApiConstants {

    private static final ResourcesReader resourcesReader = new ResourcesReader();
    public static final Properties props = resourcesReader.loadPropertiesFile(FILE_PATH);
    public static String BEARER_TOKEN = "dcaa4f45-1785-4996-83fe-3e18600a6d06";
    public static final String LAUNCHES = "/api/v1/default_personal/launch/";
}
