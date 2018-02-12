package cars.carsPage;

import cars.entity.Car;
import framework.element.Button;
import framework.element.ComboBox;
import framework.element.Label;
import org.openqa.selenium.By;

public class ComparePage extends AbstractPage {

    private String locatorForAssertIsOpen = "//div[contains(@class, 'col-group')]//div[contains(@class, 'col-12')]";
    private String locatorForComboBoxList = "//form[@id='mainAddCarForm']//select[contains(@id, '%s')]";
    private Button btnDone = new Button(By.xpath("//form[@id='mainAddCarForm']//button"));

    public ComparePage() {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }

    public void addCarToCompare(Car car) {
        indicateValueInComboBox("make", car.getName());
        indicateValueInComboBox("model", car.getModel());
        indicateValueInComboBox("year", car.getYear());
        btnDone.clickAndWait();
    }

    private void indicateValueInComboBox(String marker, String value) {
        ComboBox comboBoxList = new ComboBox(By.xpath(String.format(locatorForComboBoxList, marker)));
        comboBoxList.click();
        Label comboBoxValue = comboBoxList.getLabelValue(value);
        comboBoxValue.click();
    }

}
