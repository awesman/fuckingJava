package cars.forms;

import cars.models.Car;
import cars.steps.CarsSteps;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CarPage extends CarsBaseForm {

    private String locatorForAssertIsOpen = "//h1[@itemprop='name']";
    private String locatorForCarFirstTrim = "//a[@ng-click='onClickViewDetails(trim)']";

    public CarPage() {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }

    public void selectCarFirstModification() {
        waitForJavaScriptToLoad();
        if (Label.getLabels(By.xpath(locatorForCarFirstTrim)).size() > 0) {
            Label labelCarFirstTrim = new Label(By.xpath(locatorForCarFirstTrim));
            labelCarFirstTrim.click();
        } else {
            navigateMainPage();
            сhooseAnotherCar();
            CarPage carPage = new CarPage();
            carPage.selectCarFirstModification();
        }
    }

    static void сhooseAnotherCar() {
        CarsSteps.cars.remove(CarsSteps.cars.size() - 1);
        CarsMainPage carsMainPage = new CarsMainPage();
        carsMainPage.navigateMenu("Read Specs & Reviews");
        String carBrand = carsMainPage.fillComboBoxAndGetValue("make");
        String carModel = carsMainPage.fillComboBoxAndGetValue("model");
        String carYearOfManufacture = carsMainPage.fillComboBoxAndGetValue("year");
        CarsSteps.cars.add(new Car(carBrand, carModel, carYearOfManufacture));
        carsMainPage.clickSearchButton();
    }
}
