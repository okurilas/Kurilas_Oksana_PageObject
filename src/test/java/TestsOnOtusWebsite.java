import config.IConfigServer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestsOnOtusWebsite {

    private Logger logger = LogManager.getLogger(TestsOnOtusWebsite.class);
    private WebDriver driver;
    private IConfigServer cfg = ConfigFactory.create(IConfigServer.class);
    private WebDriverWait wait;
    //private WebElementUtils webElementUtils = new WebElementUtils();
    private AuthFormComponent authFormComponent = new AuthFormComponent();
    private OpenLKclass openLKclass = new OpenLKclass();
    private Actions actions;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
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
    public void openOtus() {
        By otusHeader = By.cssSelector(".header2__logo");
        By aboutMe = By.xpath("//a[contains(text(),'О себе')]");
        By contactOption = By.cssSelector("div.input.input_full.lk-cv-block__input.input_straight-bottom-right.input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation");
        By vk = By.xpath("//button[contains(text(),'VK')]");
        By facebook = By.xpath("//button[contains(text(),'Facebook')]");
        By contactValueOne = By.id("id_contact-0-value");
        By contactValueTwo = By.id("id_contact-1-value");
        By add = By.xpath("//button[contains(text(),'Добавить')]");
        By save = By.xpath("//button[contains(text(),'Сохранить и продолжить')]");

        logger.info("Открыть website OTUS");

        init();

        driver.get(cfg.urlOTUS());//driver.get("http://otus.ru");

        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(otusHeader)).isEnabled());

        authFormComponent.auth(driver, wait, logger);
        openLKclass.openLK(wait, logger);

        logger.info("Открываем секцию О СЕБЕ");
        wait.until(ExpectedConditions.elementToBeClickable(aboutMe))
                .click();

        actions
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.SPACE)
                .perform();


        logger.info("Вводим первый контакт 'ВК'");
        wait.until(ExpectedConditions.presenceOfElementLocated(contactOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(vk))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(contactValueOne))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(contactValueOne))
                .sendKeys("VK");

        logger.info("Вводим второй контакт 'ФБ'");
        wait.until(ExpectedConditions.elementToBeClickable(add))
                .click();

        List<WebElement> li = driver.findElements(contactOption);
        li.get(1).click();

        List<WebElement> fb = driver.findElements(facebook);
        fb.get(1).click();

        wait.until(ExpectedConditions.elementToBeClickable(contactValueTwo))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(contactValueTwo))
                .sendKeys("FB");

        logger.info("Сохраняем");
        wait.until(ExpectedConditions.elementToBeClickable(save))
                .click();


        //driver.close();
        driver.quit();

        init();


        logger.info("Драйвер поднят");

        driver.get(cfg.urlOTUS());//driver.get("http://otus.ru");


        authFormComponent.auth(driver, wait, logger);
        openLKclass.openLK(wait, logger);

        wait.until(ExpectedConditions.elementToBeClickable(aboutMe))
                .click();

        actions
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.SPACE)
                .perform();

        logger.info("Финальная проверка");
        String contactOne = wait.until(ExpectedConditions.presenceOfElementLocated(contactOption)).getText();
        logger.info(contactOne);
        Assert.assertTrue(contactOne.contains("Facebook"));

        List<WebElement> contactTwoValue = driver.findElements(contactOption);
        String contactTwo = contactTwoValue.get(1).getText();
        logger.info(contactTwo);
        Assert.assertTrue(contactTwo.contains("VK"));

    }

    private void init(){
        driver = new ChromeDriver();
        logger.info("драйвер поднят");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }


}


