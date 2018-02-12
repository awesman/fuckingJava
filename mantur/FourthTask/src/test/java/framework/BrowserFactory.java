package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private BrowserFactory() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static synchronized WebDriver getDriver(String browser) {
        if (driver == null) {
            if (System.getProperty("os.name").startsWith("Linux")) {
                if ("chrome".equals(browser)) {
                    System.setProperty("webdriver.chrome.driver",
                            PropertiesReader.getResourcesPath() + "/chromedriver");
                    driver = new ChromeDriver();
                } else if ("firefox".equals(browser)) {
                    System.setProperty("webdriver.gecko.driver",
                            PropertiesReader.getResourcesPath() + "/geckodriver");
                    driver = new FirefoxDriver();
                } else {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Incorrect browser. Check config file!");
                    }
                }
            } else {
                if ("chrome".equals(browser)) {
                    System.setProperty("webdriver.chrome.driver",
                            PropertiesReader.getResourcesPath() + "/chromedriver.exe");
                    driver = new ChromeDriver();
                } else if ("firefox".equals(browser)) {
                    System.setProperty("webdriver.gecko.driver",
                            PropertiesReader.getResourcesPath() + "/geckodriver.exe");
                    driver = new FirefoxDriver();
                } else {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Incorrect browser. Check config file!");
                    }
                }
            }

        }
        driver.manage().timeouts().implicitlyWait(PropertiesReader.getTimeOut(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}