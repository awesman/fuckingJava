package framework.element;

import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {

    protected WebDriver driver= Browser.getInstance().getDriver();
    protected WebElement element;

    public BaseElement(By locator) {
        //Waiter.waitForElementsVisible(locator);
        this.element = driver.findElement(locator);

    }

    public BaseElement() {
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
}
