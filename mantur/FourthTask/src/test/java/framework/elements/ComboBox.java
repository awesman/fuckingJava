package framework.elements;

import framework.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComboBox extends BaseElement {
    public ComboBox(By by) {
        super(by);
    }

    public List<Label> getListValues() {
        List<Label> list = new ArrayList<Label>();
        List<WebElement> webElementList = getElement().findElements(By.xpath(".//option[@label]"));
        for (WebElement we : webElementList) {
            list.add(new Label(we));
        }
        return list;
    }

    public Label getLabelValue(String value) {
        return new Label(getElement()
                .findElement(By.xpath(String.format("./option[contains(@label, '%s')]", value))));
    }
}


