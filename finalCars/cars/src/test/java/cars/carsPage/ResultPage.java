package cars.carsPage;

import cars.entity.Car;
import framework.Waiter;
import framework.element.Button;
import framework.element.ComboBox;
import framework.element.Label;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class ResultPage extends AbstractPage {

    private String locatorForNeededLine = "//cars-compare-compare-info[contains(@header, '%s')]/div[contains(@class, 'info-column')]";
    private String locatorForAssertIsOpen = "//div[contains(@class, 'compare-categories')]";
    private String addCar = "//div[@id='icon-div']";
    private String locatorForComboBoxList = "//form[@id='addCarFormModal']//select[contains(@id, '%s')]";
    private String locatorForSearch = "//div[contains(@class, 'modal')]//button";
    private Button btnAddCar = new Button(By.xpath("//div[@id='icon-div']"));
    private static final int CORRECT_RESULT = 4;


    public ResultPage() {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }

    public boolean checkEngineAndTransmission(ArrayList<Car> cars) {
        int result = 0;
        int j = cars.size();
        System.out.println(j);
        for (Car car : cars) {
            Label labelEngineValueCar = new Label(By.xpath(String.format(locatorForNeededLine, "Engine", j)));
            System.out.println(labelEngineValueCar.getText());
            if (labelEngineValueCar.getText().contains(car.getEngine())) {
                result++;
            }
            Label labelTransmissionValueCar = new Label(By.xpath(
                    String.format(locatorForNeededLine, "Transmission", j)));
            System.out.println(labelTransmissionValueCar.getText());
            if (labelTransmissionValueCar.getText().contains(car.getTransmission())) {
                result++;
            }
            j--;
        }
        System.out.println("resutl compare = " + result);
        return result == CORRECT_RESULT;
    }

    public void addCar() {
        Waiter.waitForElementsClickable(By.xpath(addCar));
        btnAddCar.click();
    }

    public void addAnotherCar(Car car) {
        indicateValueInComboBox("make", car.getName());
        indicateValueInComboBox("model", car.getModel());
        indicateValueInComboBox("year", car.getYear());
        Button btnDone = new Button(By.xpath(locatorForSearch));
        btnDone.clickAndWait();
    }

    private void indicateValueInComboBox(String marker, String value) {
        ComboBox cmbList = new ComboBox(By.xpath(String.format(locatorForComboBoxList, marker)));
        cmbList.click();
        Label cmbValue = cmbList.getLabelValue(value);
        cmbValue.click();
    }
}
