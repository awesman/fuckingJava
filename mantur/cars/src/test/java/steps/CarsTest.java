package steps;

import carsPage.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entity.Car;
import framework.BaseTest;
import framework.Browser;

import static org.testng.Assert.assertTrue;

public class CarsTest extends BaseTest{

    private static Car firstCar = new Car();
    private static Car secondCar = new Car();
    private ConfigurationPage config = new ConfigurationPage();
    private MainPage mainPage = new MainPage();
    private ResearchPage researchpage = new ResearchPage();
    private InfoPage infoPage = new InfoPage();
    private ResultPage result = new ResultPage();
    private MainPage mainPage2 = new MainPage();
    private ResearchPage researchpage2 = new ResearchPage();


    @Given("^Open browser and navigate to page Cars$")
    public void Open_browser_and_navigate_to_page_Cars() {
        Browser.openPage("https://www.cars.com/");
    }

    @When("^navigate to Research page$")
    public void Navigate_to_Research_page() {
        mainPage.navigateResearch();
    }

    @When("^choose random parameters$")
    public void choose_random_parameters() {
        researchpage.chooseCar();
    }

    @When("^set Car name year model and navigate to trim comparison$")
    public void set_Car_name_year_model_and_navigate_to_trim_comparison() {
        infoPage.checkTrimsHref(researchpage,mainPage);
        infoPage.setCarParameters(firstCar);
        infoPage.navigateTrims();
        infoPage.navigateCompare();
    }

    @When("^set engine and transmission$")
    public void set_engine_and_transmission() {
        firstCar.setEngine(config.getEngine());
        firstCar.setTransmission(config.getTransmission());
        System.out.println(firstCar);
    }

    @Then("^navigate to main page$")
    public void navigate_to_main_page() {
        config.navigateMainPage();
    }

    @Given("^open research page$")
    public void open_research_page() {
        mainPage.navigateResearch();
    }

    @When("^set secondCar name year model and navigate to trim comparison$")
    public void set_secondCar_name_year_model_and_navigate_to_trim_comparison() {
        infoPage.checkTrimsHref(researchpage2,mainPage2);
        infoPage.setCarParameters(secondCar);
        infoPage.navigateTrims();
        infoPage.navigateCompare();
    }

    @When("^set secondCar engine and transmission$")
    public void set_secondCar_engine_and_transmission() {
        ConfigurationPage conf = new ConfigurationPage();
        secondCar.setEngine(conf.getEngine());
        secondCar.setTransmission(conf.getTransmission());
        System.out.println(secondCar);
    }

    @Then("^navigate to research page$")
    public void navigate_to_research_page() {
        mainPage.navigateResearch();
    }

    @Given("^open Side-by-Side Comparisons$")
    public void open_Side_by_Side_Comparisons() {
        researchpage.navigateCompare();
    }

    @When("^choose first car and start compare$")
    public void choose_first_car_and_start_compare() {
        ComparePage compare = new ComparePage();
        compare.chooseCar(firstCar);
    }

    @When("^add second car$")
    public void add_second_car() {
        ComparePage comp = new ComparePage();
        comp.addCar();
        comp.addNewCar(secondCar);
    }

    @Then("^compare cars$")
    public void compare_cars() {
        boolean isCorrectFields =result.checkEngineAndTransmission(secondCar,firstCar);
        System.out.println(isCorrectFields);
        assertTrue(isCorrectFields);
       // System.out.println(result.compareFirstCarName(firstCar));
       // System.out.println(result.compareFirstCarEngine(firstCar));
        //System.out.println(result.compareSecondCarName(secondCar));
        //System.out.println(result.compareSecondCarEngine(secondCar));

    }
}
