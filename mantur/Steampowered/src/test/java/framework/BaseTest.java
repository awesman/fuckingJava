package framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

public abstract class BaseTest {

    protected WebDriver driver;
    protected Properties properties;
    protected String locale;
    protected Properties localeProperties;
    protected String fileName;
    protected String downloadPath;
    protected String gameLabel;
    protected String actionLabel;
    protected WebDriverWait wait;


    @BeforeClass
    public void setup() {
        driver = BrowserFactory.getInstance().getDriver();
        properties = ProjectProperties.getProperties();
        locale = properties.getProperty("locale");
        localeProperties = new LocaleProperties(locale).getProperties();
        String os = System.getProperty("os.name").substring(0,3).toLowerCase();
        fileName = os.equals("win") ? properties.getProperty("win.name") : properties.getProperty("linux.name");
        downloadPath=System.getProperty("user.dir");
        gameLabel = localeProperties.getProperty("menu.category");
        actionLabel = localeProperties.getProperty("game.category");
        wait = new WebDriverWait(driver, 50);
    }

    @AfterClass
    public void afterSuite() {
        BrowserFactory.getInstance().getDriver().quit();
    }
}