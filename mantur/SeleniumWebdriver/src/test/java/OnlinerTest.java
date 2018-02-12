import OnlinerPage.LoginPage;
import OnlinerPage.MainPage;
import org.testng.annotations.AfterClass;
import parser.ProjectProperties;
import util.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class OnlinerTest {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
        driver = DriverFactory.getInstance().getDriver();
    }

    @Test
    @Parameters("SEARCH_CATEGORY")
    public void pageOpenTest(String s) throws IOException {

        assertTrue(mainPage.enterPage());
        mainPage.navigateLoginPage();
        loginPage.enterUserData();
        loginPage.clickloginButton();
        assertTrue(mainPage.checkLoginUser());
        mainPage.navigateMenu(s);
        assertEquals(s,mainPage.getResultName());
        mainPage.navigateBackMain();
        mainPage.getOpinion(ProjectProperties.getProperties().getProperty("file.name"));
        mainPage.logOut();
        //assertFalse(mainPage.checkLogoutUser());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
