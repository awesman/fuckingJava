package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class Waiter {

    protected static Properties properties= ProjectProperties.getProperties();
    private static WebDriverWait webDriverWait;

    static {
        webDriverWait = new WebDriverWait(Browser.getInstance().getDriver(), Integer.parseInt(properties.getProperty("wait.time")));
    }

    public static void waitForElementsVisible(By locator) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementsClickable(By locator) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementsLocated(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }



}
