package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseEntity {
    protected static WebDriver driver;
    protected WebDriverWait wait;

    protected BaseEntity() {
        this.driver = BrowserFactory.getDriver();
        this.wait = new WebDriverWait(driver, PropertiesReader.getTimeOut());
    }

    protected void waitForJavaScriptToLoad() {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").toString().equals("complete");
            }
        });
    }

    protected void waitForJQueryToLoad() {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                try {
                    return ((Long) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        });
    }

    protected void waitForElementToVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitForElementToVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForElementsToVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}
