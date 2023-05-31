package api;

import com.epam.data.ResourcesReader;

import java.util.Properties;

import static com.epam.data.Constants.FILE_PATH;

abstract public class ApiBaseTest {

    private static final ResourcesReader resourcesReader = new ResourcesReader();
    public static final Properties props = resourcesReader.loadPropertiesFile(FILE_PATH);
}
