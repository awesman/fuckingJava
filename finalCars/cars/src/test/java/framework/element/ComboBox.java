package framework.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComboBox extends BaseElement {

    public ComboBox(By by) {
        super(by);
    }

    public List<Label> getListValues() {
        List<Label> list = new ArrayList<>();
        List<WebElement> webElementList = getElement().findElements(By.xpath(".//option[@label]"));
        list.addAll(webElementList.stream().map(Label::new).collect(Collectors.toList()));
        return list;
    }

    public Label getLabelValue(String value) {
        return new Label(getElement()
                .findElement(By.xpath(String.format("./option[contains(@label, '%s')]", value))));
    }
}
