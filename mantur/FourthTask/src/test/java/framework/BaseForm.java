package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public abstract class BaseForm extends BaseEntity {

    protected FluentWait fluentWait;
    protected By byLocator;

    protected BaseForm() {

        this.fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        PageFactory.initElements(driver, this);
    }

    protected void waitForIsElementExists(final By by) {
        fluentWait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver webDriver) {
                return webDriver.findElements(by);
            }
        });
    }

    protected boolean assertIsOpen() {
        driver.findElement(byLocator);
        return true;
    }
}
