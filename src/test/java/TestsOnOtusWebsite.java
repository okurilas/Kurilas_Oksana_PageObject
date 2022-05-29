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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LKPage;
import pages.LoginPage;
import pages.UserPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TestsOnOtusWebsite  {

    private Logger logger = LogManager.getLogger(TestsOnOtusWebsite.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp(){
        logger.info("драйвер поднят");
        init();
    }

    @After
    public void close(){
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void changeAboutMeSection() {

        logger.info("Открыть website OTUS");

        LoginPage loginPage = new LoginPage(driver);
        WebElement headerOTUS = loginPage.open();
        Assert.assertTrue(headerOTUS.isEnabled());

        String UserLogin = loginPage.cfg.login();
        String UserPWD = loginPage.cfg.pwd();

        loginPage.login(UserLogin, UserPWD);

        UserPage userPage = new UserPage(driver);
        userPage.openLK();

        logger.info("Открываем секцию О СЕБЕ");

        LKPage lkPage = new LKPage(driver);
        lkPage.openAboutMeSection();

        lkPage.changePersonalData();

        lkPage.setCountryAndCity();
        lkPage.checkCountryField();

        lkPage.changeContactData("VK",0, 1, 0);
        lkPage.addContact();
        lkPage.changeContactData("FB",1, 8, 1);
        lkPage.saveChangedData();

        driver.close();

        init();
        logger.info("Драйвер поднят");

        loginPage = new LoginPage(driver);
        loginPage.open();

        loginPage.login(UserLogin, UserPWD);

        userPage = new UserPage(driver);
        userPage.openLK();

        logger.info("Открываем секцию О СЕБЕ");

        lkPage = new LKPage(driver);
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
    }

    private void init(){
        String brName = System.getProperty("browser").toUpperCase(Locale.ROOT);
        driver = WebDriverFactory.getDriver(Browsers.valueOf(brName));//driver = WebDriverFactory.getDriver(Browsers.CHROME);

        logger.info("драйвер поднят");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}


