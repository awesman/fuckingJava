package cars.forms;

import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;

import java.util.List;

public class CarsMainPage extends CarsBaseForm {

    private String locatorForAssertIsOpen = "//div[contains(@class, 'promo-copy') and contains(@class, 'container')]";
    private String locatorForMainMenu = "//span[contains(text(), '%s')]";
    private String locatorForComboBoxList = "//div[@class='input-group-xl']/select[contains(@ng-model, '%s')]";
    private String locatorForSearch = "//input[@data-linkname='Research']";

    public CarsMainPage() {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }

    public void navigateMenu(String mainMenuValue) {
        waitForJavaScriptToLoad();
        Label labelMainMenu = new Label(By.xpath(String.format(locatorForMainMenu, mainMenuValue)));
        labelMainMenu.clickViaAction();
    }

    public String fillComboBoxAndGetValue(String value) {
        ComboBox comboBoxList = new ComboBox(By.xpath(String.format(locatorForComboBoxList, value)));
        comboBoxList.click();
        List<Label> list = comboBoxList.getListValues();
        Label labelBrandValue = list.get((int) (Math.random() * list.size()));
        labelBrandValue.click();
        return labelBrandValue.getAttribute("label");
    }

    public void clickSearchButton() {
        Button buttonSearch = new Button(By.xpath(locatorForSearch));
        buttonSearch.click();
    }
}
