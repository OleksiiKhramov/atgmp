package ui_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.epam.data.ResourcesReader;
import com.epam.ui.steps.CommonSteps;
import com.epam.ui.pages.LaunchesPage;
import com.epam.ui.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import lombok.Getter;

import java.util.Properties;

import static com.epam.data.Constants.FILE_PATH;

@Getter
public class BaseTest {

    private static final ResourcesReader resourcesReader = new ResourcesReader();
    private static final Properties props = resourcesReader.loadPropertiesFile(FILE_PATH);
    LoginPage loginPage = new LoginPage();
    LaunchesPage launchesPage = new LaunchesPage();
    CommonSteps commonSteps = new CommonSteps();

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = (props.getProperty("browser.type"));
        loginPage.setBaseUrl(props.getProperty("login.url"));
        loginPage.open();
        commonSteps.login();
    }

    @AfterTest
    public void afterTest() {
        Selenide.closeWebDriver();
    }

    @DataProvider(name = "filterByFailures")
    public static Object[][] primeNumbers() {
        return new Object[][] { { "fl", "failed" }, { "skp", "skipped" }, { "to invest", "to invest" } };
    }
}
