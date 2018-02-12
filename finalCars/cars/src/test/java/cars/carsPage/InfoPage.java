package cars.carsPage;

import framework.Waiter;
import framework.element.Label;
import org.openqa.selenium.By;

public class InfoPage extends AbstractPage {

    private String compare = "//div[@id='mmy-trims']//a";
    private Label compareLbl = new Label(By.xpath("//div[@id='mmy-trims']//a"));
    private Label name = new Label(By.xpath("//div[contains(@class, 'mmy-header__title-container')]//a[contains(@data-linkname, 'bc-make')]"));
    private Label model = new Label(By.xpath("//div[contains(@class, 'mmy-header__title-container')]//a[contains(@data-linkname, 'bc-model')]"));
    private Label year = new Label(By.xpath("//div[contains(@class, 'mmy-header__title-container')]//h1"));

    private String locatorForAssertIsOpen = "//div[contains(@class, 'page-container') and contains(@class, 'hero')]//div[contains(@class, 'mmy-header__title-year')]";

    public InfoPage() {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }

    public void navigateCompare() {
        Waiter.waitForElementsClickable(By.xpath(compare));
        compareLbl.click();
    }

    public String getCarName() {
        return name.getText();
    }

    public String getCarModel() {
        return model.getText();
    }

    public String getCarYear() {
        return year.getText().substring(0, 4);
    }
}
