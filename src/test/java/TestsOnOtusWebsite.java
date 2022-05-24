import driverFactory.Browsers;
import driverFactory.WebDriverFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LKPage;
import pages.LoginPage;
import pages.UserPage;

import java.time.Duration;
import java.util.List;

public class TestsOnOtusWebsite  {

    private Logger logger = LogManager.getLogger(TestsOnOtusWebsite.class);
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;




    @Before
    public void setUp(){
        String brName = System.getProperty("br");
        logger.info("драйвер поднят");
    }

    @After
    public void close(){
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void changeAboutMeSection() throws InterruptedException {

        logger.info("Открыть website OTUS");

        init();
        LoginPage loginPage = new LoginPage(driver, wait);
        WebElement headerOTUS = loginPage.open();
        Assert.assertTrue(headerOTUS.isEnabled());

        String UserLogin = loginPage.cfg.login();
        String UserPWD = loginPage.cfg.pwd();

        loginPage.login(UserLogin, UserPWD);

//        WebElement avatarPic = loginPage.login(UserLogin, UserPWD);
//        Assert.assertTrue((avatarPic).isDisplayed());


        UserPage userPage = new UserPage(driver, wait);
        userPage.openLK();
//        String text = userPage.openLK();
//        Assert.assertTrue(text.contains("Личный кабинет"));

        logger.info("Открываем секцию О СЕБЕ");

        LKPage lkPage = new LKPage(driver,wait);
        lkPage.openAboutMeSection();
        //userPage.openAboutMeSection();

        lkPage.changePersonalData();
//        userPage.changeName();

        actions = new Actions(driver);//
        actions
                .sendKeys(Keys.SPACE)
                .perform();

        lkPage.changeAddress();
//        userPage.changeAddress();





//        List<WebElement> vkk = driver.findElements(By.xpath("//button[contains(text(),'VK')]"));
//        List<WebElement> facebook = driver.findElements(By.xpath("//button[contains(text(),'Facebook')]"));
//        WebElement contactValueOne = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("id_contact-0-value")));
//        WebElement contactValueTwo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("id_contact-1-value")));

        //(String ValueOfContact, Integer i,List<WebElement> contactType,WebElement contactValue)
        actions
                .sendKeys(Keys.SPACE)
                .perform();
        lkPage.changeContactData("VK",0, 1, 0);
        lkPage.addContact();
        lkPage.changeContactData("FB",1, 8, 1);
        lkPage.saveChangedData();

//        userPage.changeContactData();

        driver.close();

        init();
        logger.info("Драйвер поднят");

        loginPage = new LoginPage(driver, wait);
        loginPage.open();

        loginPage.login(UserLogin, UserPWD);

        //avatarPic = loginPage.login(UserLogin, UserPWD);
        //Assert.assertTrue((avatarPic).isDisplayed());



//        logger.info("Авторизация прошла успешно");

        userPage = new UserPage(driver, wait);
        userPage.openLK();

//        text = userPage.openLK();
//        Assert.assertTrue(text.contains("Личный кабинет"));

        logger.info("Открываем секцию О СЕБЕ");

        lkPage = new LKPage(driver,wait);
        lkPage.openAboutMeSection();

        logger.info("Финальная проверка");

        String valueFirstName = lkPage.getFirstName();
        Assert.assertTrue(valueFirstName.contains("Оксана"));

        String valueFirstNameLatin = lkPage.getFirstNameLatin();
        Assert.assertTrue(valueFirstNameLatin.contains("Oksana"));

        String valueLastName = lkPage.getLastName();
        Assert.assertTrue(valueLastName.contains("Курилас"));

        String valueLastNameLatin = lkPage.getLastNameLatin();
        Assert.assertTrue(valueLastNameLatin.contains("Kurilas"));

        String valueFistNameInBlog = lkPage.getFirstNameInBlog();
        Assert.assertTrue(valueFistNameInBlog.contains("Оксана"));

        String valueDateOfBirth = lkPage.getDateOfBirth();
        Assert.assertTrue(valueDateOfBirth.contains("21.09.1988"));

        actions = new Actions(driver);//
        actions
                .sendKeys(Keys.SPACE)
                .perform();

        String CountryCheck = lkPage.getCountry();
        Assert.assertTrue(CountryCheck.contains("Россия"));

        String CityCheck = lkPage.getCity();
        Assert.assertTrue(CityCheck.contains("Санкт-Петербург"));

        String LanguageCheck = lkPage.getLanguage();
        Assert.assertTrue(LanguageCheck.contains("Выше среднего (Upper Intermediate)"));

        String contactOne = lkPage.checkContacts(0);
        Assert.assertTrue(contactOne.contains("Facebook"));
        String contactTwo = lkPage.checkContacts(1);
        Assert.assertTrue(contactTwo.contains("VK"));

//        String contactOne = lkPage.finalCheckContactOne();
//        Assert.assertTrue(contactOne.contains("Facebook"));
//        String contactTwo = lkPage.finalCheckContactTwo();
//        Assert.assertTrue(contactTwo.contains("VK"));

    }

    private void init(){
        //String brName = System.getProperty("br");
        driver = WebDriverFactory.getDriver(Browsers.CHROME);
        logger.info("драйвер поднят");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //actions = new Actions(driver);
    }


}


