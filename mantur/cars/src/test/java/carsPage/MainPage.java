package carsPage;

import framework.element.Button;
import org.openqa.selenium.By;

public class MainPage extends AbstractPage {

    private static final By RESEARCH = By.xpath("//ul[@class='global-nav__menu']//a[contains(text(),'Research')]");

    public void navigateResearch() {
        new Button(RESEARCH).click();
    }

}
