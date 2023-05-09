package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "cucumber/features" }, glue = { "cucumber/steps" },
                 plugin = { "pretty", "html:build/reports/cucumber_html_report.html" })
public class CucumberRunner {

}
