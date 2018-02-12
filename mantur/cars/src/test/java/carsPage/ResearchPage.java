package carsPage;

import framework.element.Button;
import framework.element.Label;
import framework.element.TextBox;
import org.openqa.selenium.By;

public class ResearchPage extends AbstractPage {

    private static final By CAR_OPTION = By.xpath("//section[@id='research-search-widget']//div[@class='hsw-makes']//option");
    private static final By CAR = By.xpath("//section[@id='research-search-widget']//div[@class='hsw-makes']//select");
    private static final By MODEL_OPTION = By.xpath("//section[@id='research-search-widget']//div[@class='hsw-models']//option");
    private static final By MODEL = By.xpath("//section[@id='research-search-widget']//div[@class='hsw-models']//select");
    private static final By YEAR_OPTION = By.xpath("//section[@id='research-search-widget']//div[@class='hsw-years']//option");
    private static final By YEAR = By.xpath("//section[@id='research-search-widget']//div[@class='hsw-years']//select");
    private static final By SEARCH = By.xpath("//input[@value='Search']");
    private static final By SIDE_BY_SIDE = By.xpath("//div[@id='ta-linkcards-container']//a");

    public void chooseCar() {
            new TextBox(CAR).randomFillForm(CAR_OPTION, CAR);
            new TextBox(MODEL).randomFillForm(MODEL_OPTION, MODEL);
            new TextBox(YEAR).randomFillForm(YEAR_OPTION, YEAR);
            new Button(SEARCH).click();
    }

    public void navigateCompare() {
        new Label(SIDE_BY_SIDE).click();
    }
}
