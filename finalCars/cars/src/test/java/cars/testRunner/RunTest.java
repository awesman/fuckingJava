package cars.testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/java/cars/features",
        glue = {"cars/steps"})
public class RunTest extends AbstractTestNGCucumberTests {

    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = Browser.getInstance().getDriver();
        Browser.openPage("https://www.cars.com/");
    }

    @AfterClass
    public void afterSuite() {
        Browser.closeBrowser();
    }
}
