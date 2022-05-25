package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserPage extends BasePage {

    @FindBy(css = "div.header2-menu__item-wrapper.header2-menu__item-wrapper__username")
    private WebElement username;
    @FindBy(xpath = "//a[contains(text(),'Личный кабинет')]")
    private WebElement lk;
    @FindBy(css ="h1.title__text")
    private WebElement lkTitle;

    @FindBy (css = "div.header2-menu__icon-img.ic-blog-default-avatar")
    private WebElement avatar;
//
//    @FindBy(xpath = "//a[contains(text(),'О себе')]")
//    private WebElement aboutMe;
////    @FindBy(css =          "div.input.input_full.lk-cv-block__input.input_straight-bottom-right.input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation")
////    private WebElement contactOption;
////    @FindBys(@FindBy(css = "div.input.input_full.lk-cv-block__input.input_straight-bottom-right.input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation"))
////    private List<WebElement> contactOptions;
//
//    @FindBy (name = "fname")
//    private WebElement firstname;
//    @FindBy (name = "fname_latin")
//    private WebElement  firstnameLatin;
//    @FindBy (name = "lname")
//    private WebElement  lastname;
//    @FindBy (name = "lname_latin")
//    private WebElement  lastnameLatin;
//    @FindBy (name = "blog_name")
//    private WebElement  blogname;
//    @FindBy (name = "date_of_birth")
//    private WebElement  birth;
//    @FindBy (css = "div.select.lk-cv-block__input.lk-cv-block__input_full.js-lk-cv-dependent-master.js-lk-cv-custom-select")
//    private WebElement  country;
//    @FindBy (xpath = "//button[contains(text(),'Россия')]")
//    private WebElement  countryValue;
//    @FindBy (xpath = "//input[@name='country']/following-sibling::div")
//    private WebElement  valueOfCountry;
//    @FindBy (xpath = "//input[@data-title='Город']/..")
//    private WebElement  city;
//    @FindBy (xpath = "//button[contains(text(),'Санкт-Петербург')]")
//    private WebElement  cityValue;
//    @FindBy (xpath = "//input[@data-title='Город']/following-sibling::div")
//    private WebElement  valueOfCity;
//    @FindBy (xpath = "//input[@data-title='Уровень знания английского языка']/..")
//    private WebElement  languageLevel;
//    @FindBy (xpath = "//button[contains(text(),'Выше среднего (Upper Intermediate)')]")
//    private WebElement  languageLevelValue;
//    @FindBy (xpath = "//input[@data-title='Уровень знания английского языка']/following-sibling::div")
//    private WebElement  valueOfLanguageLevel;
//
//
//    @FindBy(css = "div.input_straight-bottom-right")
//    private WebElement contactOption;
//    @FindBys(@FindBy(css = "div.input_straight-bottom-right"))
//    private List<WebElement> contactOptions;
//
//    @FindBy(xpath = "//button[contains(text(),'VK')]")
//    private WebElement vk;
//    @FindBys(@FindBy(xpath = "//button[contains(text(),'Facebook')]"))
//    private List<WebElement> facebook;
//    @FindBy(id = "id_contact-0-value")
//    private WebElement contactValueOne;
//    @FindBy(id = "id_contact-1-value")
//    private WebElement contactValueTwo;
//    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
//    private WebElement add;
//    @FindBy(xpath = "//button[contains(text(),'Сохранить и продолжить')]")
//    private WebElement save;

    public UserPage(WebDriver driver, WebDriverWait wait) {
       super(driver, wait);
    }

    public LKPage openLK(){

        logger.info("Открыть Личный кабинет");

        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(username))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(lk))
                .click();
        String text = wait.until(ExpectedConditions.visibilityOf(lkTitle))
                .getText();
        return new LKPage(driver,wait);
    }
//
//    public void openAboutMeSection() {
//        wait.until(ExpectedConditions.elementToBeClickable(aboutMe))
//                .click();
//
//    }
//
//    public void changeName() {
//        logger.info("Редактируем Персональные данные");
//
//        logger.info("Вводим ИМЯ");
//        wait.until(ExpectedConditions.elementToBeClickable(firstname))
//                .clear();
//        wait.until(ExpectedConditions.elementToBeClickable(firstname))
//                .sendKeys("Оксана");
//
//        logger.info("Вводим ИМЯ (латиницей)");
//        wait.until(ExpectedConditions.elementToBeClickable(firstnameLatin))
//                .clear();
//        wait.until(ExpectedConditions.elementToBeClickable(firstnameLatin))
//                .sendKeys("Oksana");
//        logger.info("Вводим ФАМИЛИЮ");
//        wait.until(ExpectedConditions.elementToBeClickable(lastname))
//                .clear();
//        wait.until(ExpectedConditions.elementToBeClickable(lastname))
//                .sendKeys("Курилас");
//
//        logger.info("Вводим ФАМИЛИЮ (латиницей)");
//        wait.until(ExpectedConditions.elementToBeClickable(lastnameLatin))
//                .clear();
//        wait.until(ExpectedConditions.elementToBeClickable(lastnameLatin))
//                .sendKeys("Kurilas");
//
//        logger.info("Вводим Имя (в блоге)");
//        wait.until(ExpectedConditions.elementToBeClickable(blogname))
//                .clear();
//        wait.until(ExpectedConditions.elementToBeClickable(blogname))
//                .sendKeys("Оксана");
//
//        logger.info("Вводим Дату рождения");
//        wait.until(ExpectedConditions.elementToBeClickable(birth))
//                .clear();
//        wait.until(ExpectedConditions.elementToBeClickable(birth))
//                .sendKeys("21.09.1988");
//
//    }
//
//        public void changeAddress() throws InterruptedException {
//
//        logger.info("Редактируем Основную информацию");
//
//        logger.info("Вводим Страну");
//        wait.until(ExpectedConditions.elementToBeClickable(country))
//                .click();
//        wait.until(ExpectedConditions.elementToBeClickable(countryValue))
//                .click();
//        logger.info("Вводим Город");
//        Thread.sleep(500);
//        wait.until(ExpectedConditions.elementToBeClickable(city))
//                .click();
//        wait.until(ExpectedConditions.elementToBeClickable(cityValue))
//                .click();
//        logger.info("Вводим Уровень английского");
//        wait.until(ExpectedConditions.elementToBeClickable(languageLevel))
//                .click();
//        wait.until(ExpectedConditions.elementToBeClickable(languageLevelValue))
//                .click();
//    }
//
//
//
//
//    public void changeContactData(){
//        logger.info("Вводим первый контакт 'ВК'");
//        wait.until(ExpectedConditions.visibilityOf(contactOption)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(vk))
//                .click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(contactValueOne))
//                .clear();
//        wait.until(ExpectedConditions.elementToBeClickable(contactValueOne))
//                .sendKeys("VK");
//
//        logger.info("Вводим второй контакт 'ФБ'");
//        wait.until(ExpectedConditions.elementToBeClickable(add))
//                .click();
//
//        List<WebElement> li = contactOptions;
//        li.get(1).click();
//
//        List<WebElement> fb = facebook;
//        fb.get(1).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(contactValueTwo))
//                .clear();
//        wait.until(ExpectedConditions.elementToBeClickable(contactValueTwo))
//                .sendKeys("FB");
//
//        logger.info("Сохраняем");
//        wait.until(ExpectedConditions.elementToBeClickable(save))
//                .click();
//
//    }
//
//    public String finalCheckOne() {
//
//        String contactOne = wait.until(ExpectedConditions.visibilityOf(contactOption)).getText();
//        logger.info(contactOne);
//        return contactOne;
//    }
//    public String finalCheckTwo() {
//
//        List<WebElement> contactTwoValue = contactOptions;
//        String contactTwo = contactTwoValue.get(1).getText();
//        logger.info(contactTwo);
//        return contactTwo;
//    }
}
