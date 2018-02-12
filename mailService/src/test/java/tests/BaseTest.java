package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BaseTest {

    private static String login = "ManturEpam@gmail.com";
    private static String password = "sPo0kyH@ll0w3En";
    private String signInLocator = "//div[@id='searchform']//a[@id='gb_70']";
    private String passwordLocator = "//input[@type='password']";
    private String nextBtnEmailLocator = "//div[@id='identifierNext']";
    private String nextBtnLocator = "//div[@id='passwordNext']";
    private String emailLocator = "//input[@type='email']";
    private String mailNavigateLocator = "//li[@id='ogbkddg:5']";
    private String menuLocator  = "//div[@id='gbwa']";
    private String writeBtnLocator = "//div[contains(text(),'НАПИСАТЬ')]";
    private String addressFieldLocator = "//textarea[@name='to']";
    private String subjectLocator = "//input[@name='subjectbox']";
    private String bodyLocator = "//div[@role='textbox']";
    private String closeLocator = "//img[@class='Ha']";
    private String draftNavigateLocator = "//a[contains(text(), 'Черновики')]";
    private String tableDraftLocator = "//div[@role='main']//tr/td";
    private String draftAddressLocator = "//input[@name='to']";
    private String draftSubjectLocator = "//div[@role='main']//h2";//"//div[@role='main']//div[@role='link']//span[contains(@class,'bog')]";//div[@role='link']//span[@class='bog']";//"//input[@name='subjectbox']";
    private String sendLocator = "//table[contains(@class,'iN')]//div[contains(@class,'J-J5-Ji')]//div[contains(text(),'Отправить')]";
    private String logoOuyLocator = "//div[@role='banner']//a[@role='button']//span";
    private String exitLocator = "//a[contains(text(),'Выйти')]";

    @Test
    public void mailServiceTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        //sign in
        WebElement signBtn = driver.findElement(By.xpath(signInLocator));
        signBtn.click();
        //enter email
        WebElement passwordElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailLocator)));
        passwordElement.sendKeys(login);
        WebElement nextEmailBtn = driver.findElement(By.xpath(nextBtnEmailLocator));
        nextEmailBtn.click();
        Thread.sleep(2000);//DELETE

        //wait passwordField
        WebElement passwordField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(passwordLocator)));
        passwordField.sendKeys(password);
        WebElement nextBtn = driver.findElement(By.xpath(nextBtnLocator));
        nextBtn.click();

        Thread.sleep(3000);//DELETE
        //enter mail
        WebElement menu = driver.findElement(By.xpath(menuLocator));
        menu.click();
        WebElement mailLabel = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mailNavigateLocator)));
        mailLabel.click();
        Thread.sleep(3000);//DELETE

        //write letter
        WebElement writeBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(writeBtnLocator)));
        writeBtn.click();

        WebElement addressField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(addressFieldLocator)));

        /*WebElement dialogWind = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(dialogWindow)));*/


        //WebElement addressField = driver.findElement(By.xpath(addressFieldLocator));
        addressField.sendKeys("draft.92@gmail.com");
        WebElement subjectField = driver.findElement(By.xpath(subjectLocator));
        subjectField.sendKeys("SeleniumTask");
        WebElement bodyField = driver.findElement(By.xpath(bodyLocator));
        bodyField.sendKeys("Important Text");
        WebElement closeBtn = driver.findElement(By.xpath(closeLocator));
        closeBtn.click();


        WebElement draftLabel = driver.findElement(By.xpath(draftNavigateLocator));
        draftLabel.click();

        Thread.sleep(5000);

        List<WebElement> tableElements =driver.findElements(By.xpath(tableDraftLocator));

        Assert.assertTrue(tableElements.size()>1);

        WebElement draftMail = driver.findElement(By.xpath(tableDraftLocator));
        draftMail.click();

        WebElement draftAddress = driver.findElement(By.xpath(draftAddressLocator));
        String address = draftAddress.getAttribute("Value");
        System.out.println(address);

        WebElement draftSubject = driver.findElement(By.xpath(draftSubjectLocator));
        String subject = draftSubject.getText();
        System.out.println(subject);

        WebElement draftBody = driver.findElement(By.xpath(bodyLocator));
        String body = draftBody.getText();
        System.out.println(body);

        WebElement sendBtn = driver.findElement(By.xpath(sendLocator));
        sendBtn.click();
        //driver.navigate().refresh();

        Thread.sleep(5000);
        WebElement logOutBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(logoOuyLocator)));
       // WebElement logOutBtn = driver.findElement(By.xpath(logoOuyLocator));
        logOutBtn.click();

        WebElement exitBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(exitLocator)));
        exitBtn.click();



        //driver.navigate().refresh();


        //Assert.assertEquals(address,"Draft_92@mail.ru");

        Thread.sleep(3000);//DELETE




        //quite
        driver.quit();
    }


}
