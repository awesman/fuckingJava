package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import parser.ProjectProperties;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static volatile DriverFactory instance;
    private WebDriver driver;
    private String os = System.getProperty("os.name").toLowerCase();
    private String driverName = ProjectProperties.getProperties().getProperty("browser.name").toLowerCase();


    private DriverFactory() {
        driver = setupDriver();
    }

    public static DriverFactory getInstance() {
        DriverFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (DriverFactory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DriverFactory();
                }
            }
        }
        return localInstance;
    }

    private WebDriver setupDriver() {
        switch (driverName) {
            case ("chrome"): {
                String path = os.equals("windows 10") ? "src/resources/drivers/chromedriver.exe" : "src/resources/drivers/chromedriver";
                System.setProperty("webdriver.chrome.driver", path);
                driver = new ChromeDriver();
                break;
            }
            case ("firefox"): {
                String path = os.equals("windows 10") ? "src/resources/drivers/geckodriver.exe" : "src/resources/drivers/geckodriver";
                System.setProperty("webdriver.gecko.driver", path);
                driver = new FirefoxDriver();
                break;
            }
        }
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(ProjectProperties.getProperties().getProperty("site.url"));
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
