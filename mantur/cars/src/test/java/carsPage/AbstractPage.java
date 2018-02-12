package carsPage;

import framework.element.Button;
import org.openqa.selenium.By;

public abstract class AbstractPage {
    
    private static final By CARS_LOGO = By.xpath("//div[contains(@class,'global-nav')]//img");

    public void navigateMainPage() {
        new Button(CARS_LOGO).click();
    }

}
