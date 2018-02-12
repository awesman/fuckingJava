package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public abstract class BaseForm extends BaseEntity {

    protected FluentWait fluentWait;
    protected By byLocator;

    protected BaseForm() {
        this.fluentWait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        PageFactory.initElements(driver, this);
    }

    protected boolean assertIsOpen() {
        driver.findElement(byLocator);
        return true;
    }
}
