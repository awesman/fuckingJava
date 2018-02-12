package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private static WebDriverWait webDriverWait;
    static int waitTime = Integer.parseInt(ProjectProperties.getProperties().getProperty("wait.time"));

    static {
        webDriverWait = new WebDriverWait(BrowserFactory.getInstance().getDriver(), waitTime);
    }

    private static void waitForElementsVisible(By locator) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForElementsVisible(String locator) {
        waitForElementsVisible(By.xpath(locator));
    }
}