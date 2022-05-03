package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserPage {

    private WebDriver driver;
    private Logger logger = LogManager.getLogger(LoginPage.class);
    private WebDriverWait wait;
    private Actions actions;

    private By username = By.cssSelector("div.header2-menu__item-wrapper.header2-menu__item-wrapper__username");
    private By lk = By.xpath("//a[contains(text(),'Личный кабинет')]");
    private By lkTitle = By.cssSelector("h1.title__text");


    private By aboutMe = By.xpath("//a[contains(text(),'О себе')]");
    private By contactOption = By.cssSelector("div.input.input_full.lk-cv-block__input.input_straight-bottom-right.input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation");
    private By vk = By.xpath("//button[contains(text(),'VK')]");
    private By facebook = By.xpath("//button[contains(text(),'Facebook')]");
    private By contactValueOne = By.id("id_contact-0-value");
    private By contactValueTwo = By.id("id_contact-1-value");
    private By add = By.xpath("//button[contains(text(),'Добавить')]");
    private By save = By.xpath("//button[contains(text(),'Сохранить и продолжить')]");

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String openLK(){


        wait = new WebDriverWait(driver, Duration.ofSeconds(10));////////////////////////////////////////
        logger.info("Открыть Личный кабинет");

        wait.until(ExpectedConditions.elementToBeClickable(username))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(lk))
                .click();
        String text = wait.until(ExpectedConditions.presenceOfElementLocated(lkTitle))
                .getText();
        return text;
        //Assert.assertTrue(text.contains("Личный кабинет"));
    }

    public void openContactData() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutMe))
                .click();

        actions = new Actions(driver);////////////////////////////////////////////////////////////////////////////
        actions
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.SPACE)
                .perform();

    }

    public void changeContactData(){
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

    }

    public String finalCheckOne() {

        String contactOne = wait.until(ExpectedConditions.presenceOfElementLocated(contactOption)).getText();
        logger.info(contactOne);
        return contactOne;
    }
    public String finalCheckTwo() {

        List<WebElement> contactTwoValue = driver.findElements(contactOption);
        String contactTwo = contactTwoValue.get(1).getText();
        logger.info(contactTwo);
        return contactTwo;
    }
}
