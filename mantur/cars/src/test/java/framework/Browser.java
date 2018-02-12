package framework;

import org.openqa.selenium.WebDriver;

public class Browser {

    private static volatile Browser instance;
    private WebDriver driver;

    private Browser() {
        driver = BrowserFactory.setupDriver();
    }

    public static Browser getInstance() {
        Browser localInstance = instance;
        if (localInstance == null) {
            synchronized (Browser.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Browser();
                }
            }
        }
        return localInstance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void openPage(String url) {
        Browser.getInstance().getDriver().get(url);
    }

    static void closeBrowser(){
        Browser.getInstance().getDriver().quit();
    }
}
