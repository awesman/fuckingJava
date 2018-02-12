package OnlinerPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parser.ProjectProperties;
import util.Waiter;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='auth-container__forms']//input[@type='text']")
    WebElement loginForm;

    @FindBy(xpath = "//div[@id='auth-container__forms']//input[@type='password']")
    WebElement passwordForm;

    @FindBy(css = ".auth-box__auth-submit")
    WebElement loginButton;

    public void enterUserData() {
        Waiter.waitForElementVisible(loginForm);
        Waiter.waitForElementVisible(passwordForm);
        loginForm.sendKeys(ProjectProperties.getProperties().getProperty("onliner.login"));
        passwordForm.sendKeys(ProjectProperties.getProperties().getProperty("onliner.password"));
    }

    public void clickloginButton() {
        Waiter.waitForElementVisible(loginButton);
        loginButton.click();
    }
}
