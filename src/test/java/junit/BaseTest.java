package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.epam.data.ResourcesReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

import static com.epam.data.Constants.FILE_PATH;
import static com.epam.ui.helpers.LoginPageHelper.loginPage;

public class BaseTest {

    private static final ResourcesReader resourcesReader = new ResourcesReader();
    private static final Properties props = resourcesReader.loadPropertiesFile(FILE_PATH);

    @BeforeAll
    public static void setUp() {
        Configuration.browser = (props.getProperty("browser.type"));
    }

    @BeforeEach
    public void login() {
        loginPage.setBaseUrl(props.getProperty("login.url"));
        loginPage.open();
    }

    @AfterEach
    public void cleanUp() {
        Selenide.closeWebDriver();
    }
}
