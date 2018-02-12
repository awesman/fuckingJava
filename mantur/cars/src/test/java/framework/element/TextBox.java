package framework.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class TextBox extends BaseElement {

    public TextBox(By locator) {
        super(locator);
    }

    public void randomFillForm(By locator, By secondLocator) {
        List<WebElement> elements = driver.findElements(locator);
        Random random = new Random();
        int optionIndex = random.nextInt(elements.size() - 1);
        Select form = new Select(driver.findElement(secondLocator));
        form.selectByIndex(++optionIndex);
    }

    public void fillForm(By locator, String carParameter) {
        Select forma = new Select(driver.findElement(locator));
        forma.selectByVisibleText(carParameter);
    }
}
