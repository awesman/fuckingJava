package cars.forms;

import cars.models.Car;
import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;

public class CarsComparePage extends CarsBaseForm {

    private String locatorForAssertIsOpen = "//h1[@id='main-headline' and contains(text(), 'Compare Cars')]";
    private String locatorForAddCar = "//div[@class='add-car-icon']";
    private String locatorForComboBoxList = "//select[@id='%s-dropdown']";
    private String locatorForDone = "//button[@class='modal-button']";
    private String locatorForNeededLine = "//cars-compare-compare-info[@header='%s']/div[@class='info-column']";
    private String locatorForValueCar = locatorForNeededLine + "/span[%d]//p";
    private static final int CORRECT_RESULT = 4;

    public CarsComparePage() throws NoSuchElementException {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }

    public void clickAddCarButton() {
        Button buttonAddCar = new Button(By.xpath(locatorForAddCar));
        buttonAddCar.clickAndWait();
    }

    public void addCarToCompare(Car car) {
        indicateValueInComboBox("make", car.getBrand());
        indicateValueInComboBox("model", car.getModel());
        indicateValueInComboBox("year", car.getYearOfManufacture());
        Button buttonDone = new Button(By.xpath(locatorForDone));
        buttonDone.clickAndWait();
    }

    private void indicateValueInComboBox(String marker, String value) {
        ComboBox comboBoxList = new ComboBox(By.xpath(String.format(locatorForComboBoxList, marker)));
        comboBoxList.click();
        Label comboBoxValue = comboBoxList.getLabelValue(value);
        comboBoxValue.click();
    }

    public boolean checkEngineAndTransmission(ArrayList<Car> cars) {
        int result = 0;
        int j = cars.size();
        for (Car car : cars) {
            Label labelEngineValueCar = new Label(By.xpath(String.format(locatorForValueCar, "Engine", j)));
            if (labelEngineValueCar.getText().contains(car.getEngine())) {
                result++;
            }
            Label labelTransmissionValueCar = new Label(By.xpath(
                    String.format(locatorForValueCar, "Transmission", j)));
            if (labelTransmissionValueCar.getText().contains(car.getTransmission())) {
                result++;
            }
            j--;
        }
        return result == CORRECT_RESULT;
    }
}
