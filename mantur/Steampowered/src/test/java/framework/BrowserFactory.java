package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static volatile BrowserFactory instance;
    private WebDriver driver;
    private String os = System.getProperty("os.name").substring(0, 3).toLowerCase();
    private String driverName = ProjectProperties.getProperties().getProperty("browser.name").toLowerCase();
    private int waitTime = Integer.parseInt(ProjectProperties.getProperties().getProperty("wait.time"));
    private String downloadPath = System.getProperty("user.dir");


    private BrowserFactory() {
        driver = setupDriver();
    }

    public static BrowserFactory getInstance() {
        BrowserFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (BrowserFactory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new BrowserFactory();
                }
            }
        }
        return localInstance;
    }

    private WebDriver setupDriver() {
        switch (driverName) {
            case ("chrome"): {
                String path = os.equals("win") ? "src/test/resources/drivers/chromedriver.exe" : "src/test/resources/drivers/chromedriver";
                System.setProperty("webdriver.chrome.driver", path);
                ChromeOptions option = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("safebrowsing.enabled", "true");
                prefs.put("download.prompt_for_download", false);
                prefs.put("download.default_directory", downloadPath);
                option.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(option);
                break;
            }
            case ("firefox"): {
                String path = os.equals("win") ? "src/test/resources/drivers/geckodriver.exe" : "src/test/resources/drivers/geckodriver";
                System.setProperty("webdriver.gecko.driver", path);
                FirefoxProfile fp = new FirefoxProfile();
                DesiredCapabilities dc = DesiredCapabilities.firefox();
                fp.setPreference("browser.download.folderList", 2);
                fp.setPreference("browser.download.dir", downloadPath);
                fp.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream; application/x-debian-package; application/x-msdownload");
                dc.setCapability(FirefoxDriver.PROFILE, fp);
                driver = new FirefoxDriver(dc);
                break;
            }
        }
        driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

}