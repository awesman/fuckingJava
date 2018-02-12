package carsPage;

import framework.element.Label;
import org.openqa.selenium.By;

public class ConfigurationPage extends AbstractPage{

    private static final By ENGINE= By.xpath("//div[@class='trim-table']//div[@class='trim-card']//div[contains(@class,'cell cell-bg grow-2')]");
    private static final By TRANSMISSION= By.xpath("//div[@class='trim-table']//div[@class='trim-card']//div[contains(@class,'cell grow-2')]");

    public String getEngine(){
        return new Label(ENGINE).getText();
    }

    public String getTransmission(){
        return new Label(TRANSMISSION).getText();
    }
}
