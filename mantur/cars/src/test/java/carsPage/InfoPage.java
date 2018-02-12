package carsPage;

import entity.Car;
import framework.Waiter;
import framework.element.Button;
import framework.element.Label;
import org.openqa.selenium.By;

public class InfoPage extends AbstractPage {

    private static final By TRIMS = By.xpath("//div[contains(@class,'menu-parent')]//a[contains(text(),'Trims')]");
    private static final By COMPARE = By.xpath("//div[@id='mmy-trims']//a");
    private static final By NAME = By.xpath("//div[@class='mmy-header__title-container']//a[@data-linkname='bc-make']");
    private static final By MODEL = By.xpath("//div[@class='mmy-header__title-container']//a[@data-linkname='bc-model']");
    private static final By YEAR = By.xpath("//div[@class='mmy-header__title-year']//h1");

    public void navigateTrims() {
        new Button(TRIMS).click();
    }

    public void navigateCompare() {
        Waiter.waitForElementsClickable(COMPARE);
        new Label(COMPARE).click();
    }

    public void setCarParameters(Car car) {
        String name = new Label(NAME).getText();
        car.setName(name);
        String model = new Label(MODEL).getText();
        car.setModel(model);
        String year = new Label(YEAR).getText().substring(0, 4);
        car.setYear(year);
    }

    public void checkTrimsHref(ResearchPage page,MainPage main){
        while(true != new Button().isPresent(COMPARE)){
            main.navigateResearch();
            page.chooseCar();
        }
    }
}
