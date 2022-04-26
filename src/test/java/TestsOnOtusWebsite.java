import config.ConfigServer;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.target.model.SessionID;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestsOnOtusWebsite {

    private Logger logger = LogManager.getLogger(TestsOnOtusWebsite.class);
    private WebDriver driver;
    //private ConfigServer cfg = ConfigFactory.create(ConfigServer.class);
    private WebDriverWait wait;


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("драйвер поднят");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void close(){
        if (driver!=null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void openOtus() throws InterruptedException {
        By otusHeader = By.cssSelector(".header2__logo");
        By aboutMe = By.xpath("//a[contains(text(),'О себе')]");
        By contactOption = By.cssSelector("div.input.input_full.lk-cv-block__input.input_straight-bottom-right.input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation");
        By other = By.cssSelector("//h3[contains(text(),'Другое')]");
        By vk = By.xpath("//button[contains(text(),'VK')]");
        By facebook = By.xpath("//button[contains(text(),'Facebook')]");
        By contactValue = By.id("id_contact-0-value");
        By add = By.xpath("//button[contains(text(),'Добавить')]");
        By save = By.xpath("//button[contains(text(),'Сохранить и продолжить')]");

        logger.info("Открыть website OTUS");

//        options.addArguments("start-fullscreen");
//        init(options);

        driver.get("http://otus.ru");

        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(otusHeader)).isEnabled());

        auth();
        openLK();

        logger.info("Открываем секцию О СЕБЕ");
        wait.until(ExpectedConditions.elementToBeClickable(aboutMe))
                .click();





        Thread.sleep(5000);
        //WebElement sectionOther = wait.until(ExpectedConditions.presenceOfElementLocated(other));

//        ScrollClass scrollClass = new ScrollClass();
//        scrollClass.scroll(wait.until(ExpectedConditions.presenceOfElementLocated(other)), driver);

        /*protected*/ Actions actions = new Actions(driver);
        actions
                .sendKeys(Keys.SPACE)
                .perform();

        Thread.sleep(5000);

        //contact.click();
        //wait.until(ExpectedConditions.elementToBeClickable(add)).click();
        logger.info("Вводим первый контакт 'ВК'");
        wait.until(ExpectedConditions.presenceOfElementLocated(contactOption)).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(vk))
                .click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(contactValue))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(contactValue))
                .sendKeys("VK");
        Thread.sleep(2000);

//        logger.info("Вводим второй контакт 'ФБ'");
//        wait.until(ExpectedConditions.elementToBeClickable(add))
//                .click();
//        Thread.sleep(2000);
//
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(contactOption)).click();
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.elementToBeClickable(facebook))
//                .click();
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.elementToBeClickable(contactValue))
//                .sendKeys("fb");
//        Thread.sleep(2000);

        logger.info("Сохраняем");
        wait.until(ExpectedConditions.elementToBeClickable(save))
                .click();

        Thread.sleep(2000);


//        В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
//        Нажать сохранить
//        Открыть https://otus.ru в "чистом браузере"
        SessionId sessionID=((ChromeDriver)driver).getSessionId();
        System.out.println("Current session1 is " + sessionID.toString());
        driver.close();

        //SessionId sessionID2=((ChromeDriver)driver).getSessionId();
//        System.out.println("Current session2 is " + sessionID2.toString());
        //driver.quit();
        WebDriver driver = new ChromeDriver();
        //Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Драйвер поднят");


        driver.get("http://otus.ru");
        SessionId sessionID3=((ChromeDriver)driver).getSessionId();
        System.out.println("Current session3 is " + sessionID3.toString());
        auth();
        openLK();

//        Проверить, что в разделе "О себе" отображаются указанные ранее данные
        wait.until(ExpectedConditions.elementToBeClickable(aboutMe))
                .click();
        actions
                .sendKeys(Keys.SPACE)
                .perform();

        Thread.sleep(5000);
        logger.info("Финальная проверка");
        String contactOne = wait.until(ExpectedConditions.presenceOfElementLocated(contactOption)).getText();
        logger.info(contactOne);
        Assert.assertTrue(contactOne.contains("VK"));

//        Критерии оценки:
//        +1 балл - код компилируется и запускается
//                +2 балл - код запускается без дополнительных действий со стороны проверяющего (не нужно скачивать WebDriver, решать конфликты зависимостей и т.п.)
//                +2 балл - логин/пароль для авторизации не зашиты в код (передаются как параметры при старте)
//        +2 балл - логи пишутся в консоль и файл
//                +2 балл - тест проходит без падений (допускается падение теса только при некорректной работе SUT)
//                +1 балл - в репозитории нет лишних файлов (.iml, директория idea и т.д.)

    }

    private void auth() {

        By loginBtn = By.xpath("//button[contains(text(),'Вход')]");
        By loginField = By.cssSelector(".js-login input[name='email']");
        By pwdField = By.xpath("//input[@type='password']");
        By loginButton = By.xpath("//button[contains(text(),'Войти')]");
        By avatar = By.cssSelector("div.header2-menu__icon-img.ic-blog-default-avatar");

        logger.info("Авторизация");


        wait.until(ExpectedConditions.elementToBeClickable(loginBtn))
                .click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfElementLocated(loginField),
                ExpectedConditions.presenceOfElementLocated(pwdField)
        ));
        $(loginField)
                .sendKeys("oksana777@list.ru");//.sendKeys(cfg.login());
        $(pwdField)
                .sendKeys("Caiman123!");//.sendKeys(cfg.pwd());
        $(loginButton)
                .submit();

        WebElement avatarPic = wait.until(ExpectedConditions.presenceOfElementLocated(avatar));
        Assert.assertTrue((avatarPic).isDisplayed());
        logger.info("Авторизация прошла успешно");
    }

    private void openLK(){
        By username = By.cssSelector("div.header2-menu__item-wrapper.header2-menu__item-wrapper__username");
        By lk = By.xpath("//a[contains(text(),'Личный кабинет')]");
        By lkTitle = By.cssSelector("h1.title__text");

        logger.info("Открыть Личный кабинет");

        wait.until(ExpectedConditions.elementToBeClickable(username))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(lk))
                .click();
        String text = wait.until(ExpectedConditions.presenceOfElementLocated(lkTitle))
                .getText();
        Assert.assertTrue(text.contains("Личный кабинет"));

    }

    private void init(ChromeOptions options){
        driver = new ChromeDriver(options);
        logger.info("драйвер поднят");
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private WebElement $(By locator) {

        return driver.findElement(locator);
    }

}


