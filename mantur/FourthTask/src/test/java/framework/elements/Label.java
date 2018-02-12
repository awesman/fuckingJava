package framework.elements;

import framework.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;



public class Label extends BaseElement {

    public Label(By by) {
        super(by);
    }

    public Label(WebElement webElement) {
        super(webElement);
    }

    public static List<Label> getLabels(By by) {
        List<Label> list = new ArrayList<Label>();
        List<WebElement> webElementList = driver.findElements(by);
        for(WebElement we : webElementList) {
            list.add(new Label(we));
        }
        return list;
    }
}
