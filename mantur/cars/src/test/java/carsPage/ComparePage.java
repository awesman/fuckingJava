package carsPage;

import entity.Car;
import framework.Waiter;
import framework.element.Button;
import framework.element.TextBox;
import org.openqa.selenium.By;

public class ComparePage extends AbstractPage {

    private static final By CAR = By.xpath("//form[@id='mainAddCarForm']//select[@id='make-dropdown']");
    private static final By MODEL = By.xpath("//form[@id='mainAddCarForm']//select[@id='model-dropdown']");
    private static final By YEAR = By.xpath("//form[@id='mainAddCarForm']//select[@id='year-dropdown']");
    private static final By START_COMPARING_NOW = By.xpath("//form[@id='mainAddCarForm']//button");
    private static final By ADD_CAR = By.xpath("//div[@id='icon-div']");
    private static final By DONE = By.xpath("//div[@class='modal']//button");
    private static final By POPUP_CAR = By.xpath("//form[@id='addCarFormModal']//select[@id='make-dropdown']");
    private static final By POPUP_MODEL = By.xpath("//form[@id='addCarFormModal']//select[@id='model-dropdown']");
    private static final By POPUP_YEAR = By.xpath("//form[@id='addCarFormModal']//select[@id='year-dropdown']");

    public void chooseCar(Car car) {
        String carName = car.getName();
        new TextBox(CAR).fillForm(CAR, carName);
        String carModel = car.getModel();
        new TextBox(MODEL).fillForm(MODEL, carModel);
        String carYear = car.getYear();
        new TextBox(YEAR).fillForm(YEAR, carYear);
        new Button(START_COMPARING_NOW).click();
    }

    public void addCar() {
        Waiter.waitForElementsClickable(ADD_CAR);
        new Button(ADD_CAR).click();
    }

    public void addNewCar(Car car) {
        String carName = car.getName();
        new TextBox(POPUP_CAR).fillForm(POPUP_CAR, carName);
        String carModel = car.getModel();
        new TextBox(POPUP_MODEL).fillForm(POPUP_MODEL, carModel);
        String carYear = car.getYear();
        new TextBox(POPUP_YEAR).fillForm(POPUP_YEAR, carYear);
        new Button(DONE).click();
    }
}
