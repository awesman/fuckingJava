package tests;

import framework.BaseTest;
import framework.Block;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;
import steam.*;

import java.awt.*;
import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SteampoweredTest extends BaseTest {

    @Test(timeOut = 100000)
    public void pageOpenTest() throws InterruptedException, AWTException {

        //Open http://store.steampowered.com/
        driver.get(properties.getProperty("site.url"));

        //Check language and switch if needed
        String currentLanguage = MainPage.checkLanguage(driver);
        MainPage.switchLanguage(currentLanguage, localeProperties.getProperty("switch.language"), locale);

        //Choose and navigate item in menu
        MainPage mainPage = new MainPage();
        mainPage.menu.selectItem(gameLabel, driver, actionLabel);

        //Choose discount tab
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickBtn();
        //Waiter.waitForElementsVisible("//div[@id='DiscountsTable']");

        //Collect all games with discount on page, sort collection, get max and go to it
        List<Block> gameBlock = Block.chooseDiscount(driver);
        Block gameWithMaxDisc = Block.getMaxDiscount(gameBlock);
        gameWithMaxDisc.getElement().click();

        //Checking validate page by URL with .../agecheck and confirm it
       if (driver.getCurrentUrl().contains("agecheck")) {
           WebElement element=driver.findElement(By.xpath("//select[@id='ageYear']/option[@value='1998']"));
           element.click();
           WebElement elem=driver.findElement(By.xpath(("//form[@id='agecheck_form']//a")));
           elem.click();
        }

        //Checking discount on GamePage with CatalogPage, then navigate do DownloadPage
        String navigateLabel = localeProperties.getProperty("download");
        GamePage gamePage = new GamePage(navigateLabel);
        String discount = gamePage.getDiscountField().getElement().getText();
        String expectedDiscount = Integer.toString(gameWithMaxDisc.getDiscountValue());
        String actualDiscount = discount.substring(1, discount.length() - 1);

        String price = gamePage.getPriceField().getElement().getText();
        String expectedPrice = Double.toString(gameWithMaxDisc.getPrice());
        String actualPrice = price.substring(1, price.length() - 4);

        assertEquals(expectedDiscount, actualDiscount);
        assertEquals(expectedPrice, actualPrice);
        gamePage.clickBtn();

        //Install file
        File steam = new File(downloadPath + fileName);
        if (steam.exists()) {
            steam.delete();
        }

        String installLabel = localeProperties.getProperty("install");
        DownloadPage downloadPage = new DownloadPage(installLabel);
        downloadPage.clickBtn();

        //Wait until download end
        wait.until((ExpectedCondition<Boolean>) webDriver -> steam.exists());
        //Check file
        assertTrue(steam.isFile());
    }
}