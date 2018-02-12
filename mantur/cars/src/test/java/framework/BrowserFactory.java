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

class BrowserFactory {

    private static WebDriver driver;
    private static String os = System.getProperty("os.name").substring(0, 3).toLowerCase();
    private static String driverName = ProjectProperties.getProperties().getProperty("browser.name").toLowerCase();
    private static int waitTime = Integer.parseInt(ProjectProperties.getProperties().getProperty("wait.time"));
    private static String downloadPath = System.getProperty("user.dir");

    static WebDriver setupDriver() {
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
}
