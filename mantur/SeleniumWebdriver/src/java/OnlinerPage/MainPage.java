package OnlinerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import parser.ProjectProperties;
import util.Waiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPage extends AbstractPage {

    final Pattern pattern = Pattern.compile(ProjectProperties.getProperties().getProperty("regexp.opinion"));
    final Matcher matcher = pattern.matcher(driver.getPageSource());

    @FindBy(css = "div.auth-bar__item.auth-bar__item--text")
    private WebElement loginNavigateButton;

    By locator = By.xpath("//div[@class='project-navigation__flex']//li");

    @FindBy(xpath = "//div[@id='userbar']//div[@class='b-top-profile__image']")
    private WebElement userBar;

    @FindBy(xpath = "//h1[@class='schema-header__title']")
    private WebElement resultBar;

    @FindBy(xpath = "//div[@class='b-top-profile__logout']//a")
    private WebElement exitButton;


    public void navigateLoginPage() {
        Waiter.waitForElementVisible(loginNavigateButton);
        loginNavigateButton.click();
    }

    public void logOut() {
        userBar.click();
        exitButton.click();
    }

    public String getResultName() {
        return resultBar.getText();
    }


    public void getOpinion(String filePath) throws IOException {
        File newFile = new File(filePath);
        try (FileWriter writer = new FileWriter(newFile, false)) {
            while (matcher.find()) {
                writer.write(matcher.group(1) + "\n");
            }
        }
    }

    public void navigateMenu(String s) {
        Waiter.waitForElementsVisible(locator);
        WebElement el = driver.findElement(By.xpath(String.format("//div[@class='project-navigation__flex']//li//span[text()='%s']", s)));
        el.click();
    }

    public boolean checkLoginUser(){
        Waiter.waitForElementVisible(userBar);
        return userBar.isDisplayed();
    }

    public boolean checkLogoutUser(){
        Waiter.waitForElementVisible(loginNavigateButton);
        return loginNavigateButton.isDisplayed();
    }

}
