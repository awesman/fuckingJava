package cars.steps;

import cars.forms.CarConfigurationPage;
import cars.forms.CarPage;
import cars.forms.CarsComparePage;
import cars.forms.CarsMainPage;
import cars.models.Car;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BrowserFactory;
import framework.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class CarsSteps {

    private WebDriver driver;

    private CarsMainPage carsMainPage;
    private CarPage carPage;
    private CarConfigurationPage carConfigurationPage;
    private CarsComparePage carsComparePage;

    public static ArrayList<Car> cars;

    @Before
    public void setUp() {
        driver = BrowserFactory.getDriver(PropertiesReader.getBrowser());
        driver.get(PropertiesReader.getUrl());
        cars = new ArrayList<Car>();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("^User open the main page$")
    public void userOpenMainPage() throws Throwable {
        carsMainPage = new CarsMainPage();
    }

    @When("^User click on menu tab '(.*)'$")
    public void navigateMenuTab(String mainMenuValue) throws Throwable {
        carsMainPage.navigateMenu(mainMenuValue);
    }

    @And("^Fill search fields with random characteristics$")
    public void fillComboBoxesByRandomValues() throws Throwable {
        String carBrand = carsMainPage.fillComboBoxAndGetValue("make");
        String carModel = carsMainPage.fillComboBoxAndGetValue("model");
        String carYearOfManufacture = carsMainPage.fillComboBoxAndGetValue("year");
        cars.add(new Car(carBrand, carModel, carYearOfManufacture));
    }

    @And("^Click Search button$")
    public void clickButtonSearch() throws Throwable {
        carsMainPage.clickSearchButton();
    }

    @Then("^Car page is open$")
    public void openCarPage() throws Throwable {
        carPage = new CarPage();
    }

    @When("On Trims tab choose the first available configuration of car$")
    public void selectCarModification() throws Throwable {
        carPage.selectCarFirstModification();
    }

    @Then("^Car configuration page is open$")
    public void openCarConfigurationPage() throws Throwable {
        carConfigurationPage = new CarConfigurationPage();
    }

    @When("^Save characteristics of car for compare$")
    public void saveCharacteristicsCar() throws Throwable {
        cars.get(cars.size() - 1).setEngine(carConfigurationPage.getEngineCurrentCar());
        cars.get(cars.size() - 1).setTransmission(carConfigurationPage.getTransmissionCurrentCar());
    }

    @When("^Go to the main page$")
    public void navigateMainPage() throws Throwable {
        carConfigurationPage.navigateMainPage();
    }

    @Then("^Main Page is open$")
    public void openMainPage() throws Throwable {
        carsMainPage = new CarsMainPage();
    }

    @And("^In the trims list choose the first configuration for compare, click Compare and Compare Now$")
    public void clickCompareAndCompareNow() throws Throwable {
        carConfigurationPage.clickCompare();
        carConfigurationPage.clickCompareNow();
    }

    @Then("^Car compare page is open$")
    public void openCompareCarsPage() throws Throwable {
        carsComparePage = new CarsComparePage();
    }

    @When("^click button Add Another Car$")
    public void clickAddCar() throws Throwable {
        carsComparePage.clickAddCarButton();
    }

    @And("^Adding the first car to comparison$")
    public void addFirstCarToCompare() throws Throwable {
        carsComparePage.addCarToCompare(cars.get(0));
    }

    @Then("^Check engine and transmission on cars compare page$")
    public void checkRequiredFields() throws Throwable {
        boolean isCorrectFields = carsComparePage.checkEngineAndTransmission(cars);
        Assert.assertTrue(isCorrectFields);
    }
}