package cars.carsPage;

import framework.BaseForm;
import framework.element.Label;
import org.openqa.selenium.By;

public abstract class AbstractPage extends BaseForm {

    private String locatorForMainMenu = "//ul[contains(@class,'global-nav__menu')]//a[text()='%s']";

    public void navigateMenu(String mainMenuValue) {
        waitForJavaScriptToLoad();
        Label labelMainMenu = new Label(By.xpath(String.format(locatorForMainMenu, mainMenuValue)));
        labelMainMenu.clickViaAction();
    }
}
