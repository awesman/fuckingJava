package cars.steps;

import cars.carsPage.*;
import cars.entity.Car;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;

public class CarsTest {

    private ConfigurationPage config;
    private MainPage mainPage;
    private ResearchPage researchPage;
    private InfoPage infoPage;
    private ComparePage compare;
    private ResultPage result;
    public static ArrayList<Car> cars = new ArrayList<Car>();

    @Given("^main page open$")
    public void main_page_open() {
        mainPage = new MainPage();
    }

    @When("^user click on menu tab '(.*)'$")
    public void user_click_on_menu_tab_Research(String mainMenuValue) {
        mainPage.navigateMenu(mainMenuValue);
    }

    @And("^fill search fields with random characteristics$")
    public void fill_search_fields_with_random_characteristics() {
        researchPage = new ResearchPage();
        researchPage.fillComboBox("make");
        researchPage.fillComboBox("model");
        researchPage.fillComboBox("year");
        researchPage.clickSearchButton();
        researchPage.checkTrimsHref("Research");
        infoPage = new InfoPage();
        String carName = infoPage.getCarName();
        String carModel = infoPage.getCarModel();
        String carYear = infoPage.getCarYear();
        cars.add(new Car(carName, carModel, carYear));
    }

    @Then("^user navigate trims -> compare$")
    public void user_navigate_trims_compare() {
        infoPage.navigateCompare();

    }

    @Then("^save car patameters and navigate main page$")
    public void save_car_patameters_and_navigate_main_page() {
        config = new ConfigurationPage();
        cars.get(cars.size() - 1).setEngine(config.getEngine());
        cars.get(cars.size() - 1).setTransmission(config.getTransmission());
        System.out.println(cars.get(cars.size() - 1));
        config.navigateMenu("Research");
    }

    @Then("^open reseach page and navigate Side-by-Side$")
    public void open_reseach_page_and_navigate_Side_by_Side() {
        researchPage = new ResearchPage();
        researchPage.navigateCompare();
    }

    @When("^open compare page and add cars$")
    public void open_compare_page_and_add_cars() {
        compare = new ComparePage();
        compare.addCarToCompare(cars.get(0));
        result = new ResultPage();
        result.addCar();
        result.addAnotherCar(cars.get(1));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^open result page and compare cars$")
    public void open_result_page_and_compare_cars() {
        boolean isCorrectFields = result.checkEngineAndTransmission(cars);
        Assert.assertTrue(isCorrectFields);
    }
}
