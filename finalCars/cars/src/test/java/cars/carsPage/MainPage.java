package cars.carsPage;

import org.openqa.selenium.By;

public class MainPage extends AbstractPage {

    private String locatorForAssertIsOpen = "//div[contains(@class, 'page-container') and contains(@class, 'homepage')]";

    public MainPage() {
        byLocator = By.xpath(locatorForAssertIsOpen);
        assertIsOpen();
    }
}
