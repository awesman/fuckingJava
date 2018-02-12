package cars.carsPage;

import framework.element.Label;
import org.openqa.selenium.By;

public class ConfigurationPage extends AbstractPage {

    private String locatorForAssertIsOpen = "//div[contains(@class, 'page-container')]//div[contains(@class, 'trim-header__title')]";
    private Label engineLbl = new Label(By.xpath("//div[contains(@class, 'trim-table')]//div[contains (@class, 'trim-card')]//div[contains(@class,'cell-bg grow-2')]"));
    private Label transmissionLbl = new Label(By.xpath("//div[contains(@class, 'trim-table')]//div[contains (@class, 'trim-card')]//div[contains(@class,'cell grow-2')]"));

    public ConfigurationPage() {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }

    public String getEngine() {
        return engineLbl.getText();
    }

    public String getTransmission() {
        return transmissionLbl.getText();
    }
}
