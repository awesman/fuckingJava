package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseEntity {

    WebDriver driver;
    private WebDriverWait wait;

    protected BaseEntity() {
        driver = Browser.getDriver();
        this.wait = new WebDriverWait(driver, 10);
    }

    protected void waitForJavaScriptToLoad() {
        wait.until((ExpectedCondition<Boolean>) webDriver -> {
            assert webDriver != null;
            return ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").toString().equals("complete");
        });
    }

    protected void waitForElementToVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitForElementToVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
