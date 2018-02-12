package framework;

import framework.element.Label;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Menu {

    private static final String MAIN_LOCATOR = "//div[@id='genre_tab']//a[text()='%s']";
    private static final String SECONDARY_LOCATOR = "//div[@id='genre_flyout']//a[contains(text(),'%s')]";

    Label mainMenuLbl;
    Label dropDownLbl;

    public void selectItem(String mainItem, WebDriver driver, String secondaryItem){
        mainMenuLbl = new Label(String.format(MAIN_LOCATOR,mainItem));
        Actions builder = new Actions(driver);
        builder.moveToElement(mainMenuLbl.getElement()).build().perform();
        dropDownLbl = new Label(String.format(SECONDARY_LOCATOR,secondaryItem));
        dropDownLbl.getElement().click();
    }
}
