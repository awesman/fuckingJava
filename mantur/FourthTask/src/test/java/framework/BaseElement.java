package framework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BaseElement extends BaseEntity {

    private By locator;
    private WebElement webElement;

    private Actions actions = new Actions(driver);

    public BaseElement(By by) {
        locator = by;
        this.webElement = driver.findElement(locator);
    }

    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getElement() {
        return webElement;
    }

    public By getLocator() {
        return locator;
    }

    public void moveMouseToElement() {
        waitForElementToVisible(locator);
        actions.moveToElement(webElement);
        actions.perform();

    }

    public void clickViaAction() {
        waitForElementToVisible(locator);
        actions.click(webElement);
        actions.perform();
    }

    public void click() {
        waitForElementToVisible(webElement);
        webElement.click();
    }

    public void clickAndWait() {
        waitForElementToVisible(webElement);
        webElement.click();
        waitForJavaScriptToLoad();
    }

    public String getChildText(By by) {
        waitForElementToVisible(by);
        return webElement.findElement(by).getText();
    }

    public String getText() {
        return webElement.getText();
    }

    public String getAttribute(String attribute) {
        return webElement.getAttribute(attribute);
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }

}
