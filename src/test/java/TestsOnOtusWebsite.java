import driverFactory.Browsers;
import driverFactory.WebDriverFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.UserPage;

import java.time.Duration;

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

        WebElement avatarPic = loginPage.login(UserLogin, UserPWD);
        Assert.assertTrue((avatarPic).isDisplayed());


        UserPage userPage = new UserPage(driver, wait);
        String text = userPage.openLK();
        Assert.assertTrue(text.contains("Личный кабинет"));

        logger.info("Открываем секцию О СЕБЕ");
        userPage.openAboutMeSection();


        userPage.changeName();

        actions = new Actions(driver);//
        actions
                .sendKeys(Keys.SPACE)
                .perform();

        userPage.changeAddress();

        userPage.changeContactData();

        driver.close();

        init();
        logger.info("Драйвер поднят");

        loginPage = new LoginPage(driver, wait);
        loginPage.open();


        avatarPic = loginPage.login(UserLogin, UserPWD);
        Assert.assertTrue((avatarPic).isDisplayed());

        userPage = new UserPage(driver, wait);

        text = userPage.openLK();
        Assert.assertTrue(text.contains("Личный кабинет"));

        userPage.openAboutMeSection();

        logger.info("Финальная проверка");

        String contactOne = userPage.finalCheckOne();
        Assert.assertTrue(contactOne.contains("Facebook"));
        String contactTwo = userPage.finalCheckTwo();
        Assert.assertTrue(contactTwo.contains("VK"));

    }

    private void init(){
        //String brName = System.getProperty("br");
        driver = WebDriverFactory.getDriver(Browsers.CHROME);
        logger.info("драйвер поднят");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //actions = new Actions(driver);
    }


}


