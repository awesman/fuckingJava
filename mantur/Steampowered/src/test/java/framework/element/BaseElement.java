package framework.element;

import framework.BrowserFactory;
import framework.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {

    WebDriver driver;
    WebElement element;

    public BaseElement(String locator) {
        driver = BrowserFactory.getInstance().getDriver();
        Waiter.waitForElementsVisible(locator);
        this.element = driver.findElement(By.xpath(locator));
    }

    public WebElement getElement() {
        return element;
    }

}
