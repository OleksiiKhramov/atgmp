package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.epam.data.ResourcesReader;
import com.epam.ui.helpers.UtilitySteps;
import com.epam.ui.pages.LaunchesPage;
import com.epam.ui.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Properties;

import static com.epam.data.Constants.FILE_PATH;

public class BaseTest {

    ResourcesReader resourcesReader = new ResourcesReader();
    Properties props = resourcesReader.loadPropertiesFile(FILE_PATH);
    LoginPage loginPage = new LoginPage();
    LaunchesPage launchesPage = new LaunchesPage();
    UtilitySteps utilitySteps = new UtilitySteps();

    @BeforeEach
    public void login() {
        Configuration.browser = (props.getProperty("browser.type"));
        loginPage.setBaseUrl(props.getProperty("login.url"));
        loginPage.open();
    }

    @AfterEach
    public void cleanUp() {
        Selenide.closeWebDriver();
    }
}
