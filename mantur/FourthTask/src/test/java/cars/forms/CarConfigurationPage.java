package cars.forms;

import cars.steps.CarsSteps;
import framework.elements.Button;
import framework.elements.CheckBox;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class CarConfigurationPage extends CarsBaseForm {

    private String locatorForAssertIsOpen = "//h1[@itemprop='vehicleConfiguration']";
    private String locatorForEngine = "engine";
    private String locatorForTransmission = "transmission";
    private String locatorForCompare = "checkbox";
    private String locatorForCompareNow = "//button[@class='cui-button']";

    public CarConfigurationPage() throws NoSuchElementException {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }

    public String getEngineCurrentCar() {
        Label labelEngine = new Label(By.id(locatorForEngine));
        return labelEngine.getText();
    }

    public String getTransmissionCurrentCar() {
        Label labelTransmission = new Label(By.id(locatorForTransmission));
        return labelTransmission.getText();
    }

    public void clickCompare() {
        if (Label.getLabels(By.className(locatorForCompare)).size() > 0) {
            CheckBox checkBoxCompare = new CheckBox(By.className(locatorForCompare));
            checkBoxCompare.click();
        } else {
            navigateMainPage();
            сhooseAnotherCarAndSaveCharacteristics();
            clickCompare();
        }
    }

    private void сhooseAnotherCarAndSaveCharacteristics() {
        CarPage.сhooseAnotherCar();
        CarPage carPage = new CarPage();
        carPage.selectCarFirstModification();
        CarConfigurationPage carConfigurationPage = new CarConfigurationPage();
        CarsSteps.cars.get(CarsSteps.cars.size() - 1).setEngine(carConfigurationPage.getEngineCurrentCar());
        CarsSteps.cars.get(CarsSteps.cars.size() - 1).setTransmission(carConfigurationPage.getTransmissionCurrentCar());
    }

    public void clickCompareNow() {
        Button checkBoxCompareNow = new Button(By.xpath(locatorForCompareNow));
        checkBoxCompareNow.click();
        waitForJavaScriptToLoad();
    }
}

