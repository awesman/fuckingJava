package framework.element;

import framework.BaseEntity;
import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseElement extends BaseEntity {

    private static WebDriver driver = Browser.getInstance().getDriver();
    protected WebElement element;
    private By locator;
    private Actions actions = new Actions(driver);

    BaseElement(By by) {
        locator = by;
        this.element = driver.findElement(locator);
    }

    BaseElement(WebElement element) {
        this.element = element;
    }

    BaseElement() {
    }

    public WebElement getElement() {
        return element;
    }

    public void click() {
        getElement().click();
    }

    public String getText() {
        return getElement().getText();
    }

    public boolean isPresent(By locator) {
        boolean present;
        try {
            driver.findElement(locator);
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }
        return present;
    }

    public void clickViaAction() {
        waitForElementToVisible(locator);
        actions.click(element);
        actions.perform();
    }

    public void clickAndWait() {
        waitForElementToVisible(element);
        element.click();
        waitForJavaScriptToLoad();
    }

}
