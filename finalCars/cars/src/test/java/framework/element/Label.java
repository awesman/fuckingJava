package framework.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Label extends BaseElement {

    public Label(By locator) {
        super(locator);
    }

    Label(WebElement webElement) {
        super(webElement);
    }

}
