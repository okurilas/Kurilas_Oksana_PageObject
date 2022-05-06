package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UserPage extends BasePage {

    @FindBy(css = "div.header2-menu__item-wrapper.header2-menu__item-wrapper__username")
    private WebElement username;
    @FindBy(xpath = "//a[contains(text(),'Личный кабинет')]")
    private WebElement lk;
    @FindBy(css ="h1.title__text")
    private WebElement lkTitle;

    @FindBy(xpath = "//a[contains(text(),'О себе')]")
    private WebElement aboutMe;
    @FindBy(css = "div.input.input_full.lk-cv-block__input.input_straight-bottom-right.input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation")
    private WebElement contactOption;
    @FindBys(@FindBy(css = "div.input.input_full.lk-cv-block__input.input_straight-bottom-right.input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation"))
    private List<WebElement> contactOptions;
    @FindBy(xpath = "//button[contains(text(),'VK')]")
    private WebElement vk;
    @FindBys(@FindBy(xpath = "//button[contains(text(),'Facebook')]"))
    private List<WebElement> facebook;
    @FindBy(id = "id_contact-0-value")
    private WebElement contactValueOne;
    @FindBy(id = "id_contact-1-value")
    private WebElement contactValueTwo;
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement add;
    @FindBy(xpath = "//button[contains(text(),'Сохранить и продолжить')]")
    private WebElement save;

    public UserPage(WebDriver driver, WebDriverWait wait) {
       super(driver, wait);
    }

    public String openLK(){

        logger.info("Открыть Личный кабинет");

        wait.until(ExpectedConditions.elementToBeClickable(username))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(lk))
                .click();
        String text = wait.until(ExpectedConditions.visibilityOf(lkTitle))
                .getText();
        return text;
    }

    public void openContactData() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutMe))
                .click();

        actions = new Actions(driver);//
        actions
                .sendKeys(Keys.SPACE)
                //.sendKeys(Keys.SPACE)
                .perform();

    }

    public void changeContactData(){
        logger.info("Вводим первый контакт 'ВК'");
        wait.until(ExpectedConditions.visibilityOf(contactOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(vk))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(contactValueOne))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(contactValueOne))
                .sendKeys("VK");

        logger.info("Вводим второй контакт 'ФБ'");
        wait.until(ExpectedConditions.elementToBeClickable(add))
                .click();

        List<WebElement> li = contactOptions;
        li.get(1).click();

        List<WebElement> fb = facebook;
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

        String contactOne = wait.until(ExpectedConditions.visibilityOf(contactOption)).getText();
        logger.info(contactOne);
        return contactOne;
    }
    public String finalCheckTwo() {

        List<WebElement> contactTwoValue = contactOptions;
        String contactTwo = contactTwoValue.get(1).getText();
        logger.info(contactTwo);
        return contactTwo;
    }
}
