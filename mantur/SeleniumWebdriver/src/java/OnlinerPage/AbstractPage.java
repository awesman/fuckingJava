package OnlinerPage;

import util.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Waiter;


public abstract class AbstractPage {

    @FindBy(xpath = "//div[@class='b-top-logo']//img")
    WebElement logo;


    protected WebDriver driver = DriverFactory.getInstance().getDriver();


    public AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateBackMain(){
        Waiter.waitForElementVisible(logo);
        logo.click();
    }

    public boolean enterPage(){
        Waiter.waitForElementVisible(logo);
        return logo.isDisplayed();
    }
}
