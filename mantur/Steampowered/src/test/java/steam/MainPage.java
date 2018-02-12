package steam;

import framework.Menu;
import framework.element.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private static final String LANGUAGE_LOCATOR = "//span[@id='language_pulldown']";
    private static final String FIELD_LANGUAGE_LOCATOR = "//div[@id='language_dropdown']//a[contains(text(),'%s')]";
    public static Menu menu;

    public MainPage() {
        menu = new Menu();
    }

    public static String checkLanguage(WebDriver driver) {
        String language = driver.findElement(By.xpath(LANGUAGE_LOCATOR)).getText();
        String locale;
        switch (language) {
            case "язык":
                locale = "ru";
                break;
            case "language":
                locale = "en";
                break;
            default:
                locale = "unknown";
        }
        return locale;
    }

    public static void switchLanguage(String currentLanguage, String languageLabel, String locale) {
        if (!currentLanguage.equalsIgnoreCase(locale)) {
            Button language = new Button(LANGUAGE_LOCATOR);
            language.clickBtn();
            Button languageField = new Button(String.format(FIELD_LANGUAGE_LOCATOR, languageLabel));
            languageField.clickBtn();
        }
    }
}