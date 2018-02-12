package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties properties;
    protected String locale;
    protected String fileName;
    protected String downloadPath;

    @BeforeClass
    public void setup() {
        driver = Browser.getInstance().getDriver();
        properties = ProjectProperties.getProperties();
        locale = properties.getProperty("locale");
        String os = System.getProperty("os.name").substring(0, 3).toLowerCase();
        fileName = os.equals("win") ? properties.getProperty("win.name") : properties.getProperty("linux.name");
        downloadPath = System.getProperty("user.dir");
    }

    @AfterClass
    public void afterSuite() {
        Browser.closeBrowser();
    }
}
