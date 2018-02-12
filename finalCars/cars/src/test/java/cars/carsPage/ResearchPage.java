package cars.carsPage;

import framework.element.Button;
import framework.element.ComboBox;
import framework.element.Label;
import org.openqa.selenium.By;

import java.util.List;

public class ResearchPage extends AbstractPage {

    private String compare = "//div[@id='mmy-trims']//a";
    private String locatorForAssertIsOpen = "//div[contains(@class, 'page-container') and contains(@class, 'hero')]";
    private String locatorForComboBoxList = "//div[contains(@class, 'form-control')]//select[contains(@ng-model, '%s')]";
    private Button btnSearch = new Button(By.xpath("//input[@value='Search']"));
    private Button sideBySide = new Button(By.xpath("//div[@id='ta-linkcards-container']//a"));

    public ResearchPage() {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }

    public void fillComboBox(String value) {
        ComboBox comboBoxList = new ComboBox(By.xpath(String.format(locatorForComboBoxList, value)));
        List<Label> list = comboBoxList.getListValues();
        Label labelBrandValue = list.get((int) (Math.random() * list.size()));
        labelBrandValue.click();
    }

    public void navigateCompare() {
        sideBySide.click();
    }

    public void clickSearchButton() {
        btnSearch.click();
    }

    public void checkTrimsHref(String mainMenuValue) {
        while (true != new Button().isPresent(By.xpath(compare))) {
            navigateMenu(mainMenuValue);
            fillComboBox("make");
            fillComboBox("model");
            fillComboBox("year");
            clickSearchButton();
        }
    }
}
