package carsPage;

import entity.Car;
import framework.Browser;
import framework.Waiter;
import framework.element.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends AbstractPage {

    WebDriver driver = Browser.getInstance().getDriver();

    private static final By FIRST_CAR_NAME = By.xpath("//div[@id='sticky-header']//div[@class='info-column']//span[@index='0']//h4");
    private static final By SECOND_CAR_NAME = By.xpath("//div[@id='sticky-header']//div[@class='info-column']//span[@index='1']//h4");
    private static final By FIRST_CAR_TRANSMITION = By.xpath("//cars-compare-compare-info[@header='Transmission']//div[@class='info-column']//span[@data-index='0']//p");
    private static final By SECOND_CAR_TRANSMITION = By.xpath("//cars-compare-compare-info[@header='Transmission']//div[@class='info-column']//span[@data-index='1']//p");
    private static final By FIRST_CAR_ENGINE = By.xpath("//cars-compare-compare-info[@header='Engine']//div[@class='info-column']//span[@data-index='0']");
            //"//cars-compare-compare-info[@header='Engine']//div[@class='info-column']//span[@data-id='USA70HYC021A0']");
    private static final By SECOND_CAR_ENGINE = By.xpath("//cars-compare-compare-info[@header='Engine']//div[@class='info-column']//span[@data-index='1']//p");


    private String locatorForNeededLine = "//cars-compare-compare-info[@header='%s']/div[@class='info-column']";
    private String locatorForValueCar = locatorForNeededLine + "/span[%d]//p";
    private static final int CORRECT_RESULT = 4;



    public boolean compareFirstCarName(Car car) {
        String fullCarName = car.getYear() + " " + car.getName() + " " + car.getModel();
        System.out.println(fullCarName);
        Waiter.waitForElementsVisible(FIRST_CAR_NAME);
        String carName = driver.findElement(FIRST_CAR_NAME).getText();
        System.out.println(carName);
        return fullCarName.equals(carName);
    }

    public boolean compareSecondCarName(Car car) {
        String fullCarName = car.getYear() + " " + car.getName() + " " + car.getModel();
        System.out.println(fullCarName);
        Waiter.waitForElementsVisible(SECOND_CAR_NAME);
        String carName = driver.findElement(SECOND_CAR_NAME).getText();
        System.out.println(carName);
        return fullCarName.equals(carName);
    }

    public boolean compareFirstCarEngine(Car car) {
        Waiter.waitForElementsLocated(FIRST_CAR_ENGINE);
       /*List<WebElement> engine=driver.findElements(FIRST_CAR_ENGINE);
        System.out.println("web elements = " + engine.size());
        List<String> eng = null;
        boolean flag=false;
        eng.addAll(engine.stream().map(WebElement::getText).collect(Collectors.toList()));
        System.out.println(eng.size());
        for(String s : eng){
            if(s.equals(car.getEngine())){
                flag=true;
            }
        }
        return  flag;*/
      // Waiter.waitForElementsLocated(FIRST_CAR_ENGINE);
        String name = driver.findElement(FIRST_CAR_ENGINE).getText();
        System.out.println("engine = " + name);
        String expectedName = car.getEngine();
        System.out.println("expected engine = " +expectedName);
        return expectedName.equals(name);
    }

    public boolean compareSecondCarEngine(Car car) {
        List<WebElement> engine = driver.findElements(SECOND_CAR_ENGINE);
        List<String> eng = null;
        boolean flag = false;
        for (WebElement e : engine) {
            eng.add(e.getText());
        }
        for (String s : eng) {
            if (s.equals(car.getEngine())) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean checkEngineAndTransmission(Car firstCar, Car secondCar) {
         ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(firstCar);
        cars.add(secondCar);
        int result = 0;
        int j = cars.size();
        System.out.println(j);
        for (Car car : cars) {
            Label labelEngineValueCar = new Label(By.xpath(String.format(locatorForValueCar, "Engine", j)));
            System.out.println(labelEngineValueCar.getText());
            if (labelEngineValueCar.getText().contains(car.getEngine())) {
                result++;
            }
            Label labelTransmissionValueCar = new Label(By.xpath(
                    String.format(locatorForValueCar, "Transmission", j)));
            System.out.println(labelTransmissionValueCar.getText());
            if (labelTransmissionValueCar.getText().contains(car.getTransmission())) {
                result++;
            }
            j--;
        }
        System.out.println("resutl compare = " + result);
        return result == CORRECT_RESULT;
    }


}
