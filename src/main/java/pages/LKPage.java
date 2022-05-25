package pages;

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

public class LKPage extends BasePage{



    @FindBy(xpath = "//a[contains(text(),'О себе')]")
    private WebElement aboutMe;
//    @FindBy(css =          "div.input.input_full.lk-cv-block__input.input_straight-bottom-right.input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation")
//    private WebElement contactOption;
//    @FindBys(@FindBy(css = "div.input.input_full.lk-cv-block__input.input_straight-bottom-right.input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation"))
//    private List<WebElement> contactOptions;

    @FindBy (name = "fname")
    private WebElement firstname;
    @FindBy (name = "fname_latin")
    private WebElement  firstnameLatin;
    @FindBy (name = "lname")
    private WebElement  lastname;
    @FindBy (name = "lname_latin")
    private WebElement  lastnameLatin;
    @FindBy (name = "blog_name")
    private WebElement  blogname;
    @FindBy (name = "date_of_birth")
    private WebElement  birth;
    @FindBy (css = "div.select.lk-cv-block__input.lk-cv-block__input_full.js-lk-cv-dependent-master.js-lk-cv-custom-select")
    private WebElement  country;
    @FindBy (xpath = "//button[contains(text(),'Россия')]")
    private WebElement  countryValue;
    @FindBy (xpath = "//input[@name='country']/following-sibling::div")
    private WebElement  valueOfCountry;
    @FindBy (xpath = "//input[@data-title='Город']/..")
    private WebElement  city;
    @FindBy (xpath = "//button[contains(text(),'Санкт-Петербург')]")
    private WebElement  cityValue;
    @FindBy (xpath = "//input[@data-title='Город']/following-sibling::div")
    private WebElement  valueOfCity;
    @FindBy (xpath = "//input[@data-title='Уровень знания английского языка']/..")
    private WebElement  languageLevel;
    @FindBy (xpath = "//button[contains(text(),'Выше среднего (Upper Intermediate)')]")
    private WebElement  languageLevelValue;
    @FindBy (xpath = "//input[@data-title='Уровень знания английского языка']/following-sibling::div")
    private WebElement  valueOfLanguageLevel;


//    @FindBy(css = "div.input_straight-bottom-right")
//    private WebElement contactOption;
    @FindBys(@FindBy(css = "div.input_straight-bottom-right"))
    private List<WebElement> contactOptions;

//    @FindBy(xpath = "//button[contains(text(),'VK')]")
//    private WebElement vk;
//    @FindBys(@FindBy(xpath = "//button[contains(text(),'VK')]"))
//    private List<WebElement> vkk;
//    @FindBys(@FindBy(xpath = "//button[contains(text(),'Facebook')]"))
//    private List<WebElement> facebook;

    @FindBys(@FindBy(xpath = "//button[@data-empty='Способ связи']//../following-sibling::button"))
    private List<WebElement> typeOfContact;

    @FindBys(@FindBy(css ="input.input.input_straight-top-left.input_straight-bottom-left.lk-cv-block__input.lk-cv-block__input_9.lk-cv-block__input_md-8"))
    private List<WebElement> contactValue;

    @FindBy(id = "id_contact-0-value")
    private WebElement contactValueOne;
    @FindBy(id = "id_contact-1-value")
    private WebElement contactValueTwo;
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement add;
    @FindBy(xpath = "//button[contains(text(),'Сохранить и продолжить')]")
    private WebElement save;





    public LKPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }




    public void openAboutMeSection() {
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(aboutMe))
                .click();

    }

    public void changePersonalData() {
        logger.info("Редактируем Персональные данные");

        logger.info("Вводим ИМЯ");
        wait.until(ExpectedConditions.elementToBeClickable(firstname))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(firstname))
                .sendKeys("Оксана");

        logger.info("Вводим ИМЯ (латиницей)");
        wait.until(ExpectedConditions.elementToBeClickable(firstnameLatin))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(firstnameLatin))
                .sendKeys("Oksana");
        logger.info("Вводим ФАМИЛИЮ");
        wait.until(ExpectedConditions.elementToBeClickable(lastname))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(lastname))
                .sendKeys("Курилас");

        logger.info("Вводим ФАМИЛИЮ (латиницей)");
        wait.until(ExpectedConditions.elementToBeClickable(lastnameLatin))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(lastnameLatin))
                .sendKeys("Kurilas");

        logger.info("Вводим Имя (в блоге)");
        wait.until(ExpectedConditions.elementToBeClickable(blogname))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(blogname))
                .sendKeys("Оксана");

        logger.info("Вводим Дату рождения");
        wait.until(ExpectedConditions.elementToBeClickable(birth))
                .clear();
        wait.until(ExpectedConditions.elementToBeClickable(birth))
                .sendKeys("21.09.1988");

//        actions = new Actions(driver);//
//        actions
//                .sendKeys(Keys.SPACE)
//                .perform();
    }

    public void changeAddress() throws InterruptedException {

        logger.info("Редактируем Основную информацию");

        logger.info("Вводим Страну");
        wait.until(ExpectedConditions.elementToBeClickable(country))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(countryValue))
                .click();
        logger.info("Вводим Город");
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(city))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(cityValue))
                .click();
        logger.info("Вводим Уровень английского");
        wait.until(ExpectedConditions.elementToBeClickable(languageLevel))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(languageLevelValue))
                .click();

        //        actions
//                .sendKeys(Keys.SPACE)
//                .perform();
    }

public  void addContact(){
    logger.info("Добавляем контакт");
    wait.until(ExpectedConditions.elementToBeClickable(add))
            .click();
}

    public void changeContactData(String ValueOfContact, Integer contactOption,Integer typeOfContacts,Integer contactValueN) {

        logger.info("Вводим контакт: " + ValueOfContact);
        List<WebElement> li = contactOptions;
        li.get(contactOption).click();

        List<WebElement> tc =typeOfContact;
        tc.get(typeOfContacts).click();

        List<WebElement> cv = contactValue;
        cv.get(contactValueN).clear();
        cv.get(contactValueN).sendKeys(ValueOfContact);
    }

    public void saveChangedData(){
        logger.info("Сохраняем");
        wait.until(ExpectedConditions.elementToBeClickable(save))
                .click();

    }
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
//    }



    public String getFirstName() {
        String valueFirstName = wait.until(ExpectedConditions.visibilityOf(firstname)).getAttribute("value");
        logger.info("ИМЯ " + valueFirstName);
        return valueFirstName;
    }

    public String getFirstNameLatin() {
        String valueFirstNameLatin = wait.until(ExpectedConditions.visibilityOf(firstnameLatin)).getAttribute("value");
        logger.info("ИМЯ (латиницей) " + valueFirstNameLatin);
        return valueFirstNameLatin;
    }

    public String getLastName() {
        String valueLastName = wait.until(ExpectedConditions.visibilityOf(lastname)).getAttribute("value");
        logger.info("Фамилия " + valueLastName);
        return valueLastName;
    }

    public String getLastNameLatin() {
        String valueLastNameLatin = wait.until(ExpectedConditions.visibilityOf(lastnameLatin)).getAttribute("value");
        logger.info("Фамилия (латиницей) " + valueLastNameLatin);
        return valueLastNameLatin;
    }

    public String getFirstNameInBlog() {
        String valueFistNameInBlog = wait.until(ExpectedConditions.visibilityOf(blogname)).getAttribute("value");
        logger.info("Имя (в блоге) " + valueFistNameInBlog);
        return valueFistNameInBlog;
    }

    public String getDateOfBirth() {
        String valueDateOfBirth = wait.until(ExpectedConditions.visibilityOf(birth)).getAttribute("value");
        logger.info("Дата рождения " + valueDateOfBirth);
        return valueDateOfBirth;
    }


    public String getCountry() {

        //        actions = new Actions(driver);//
//        actions
//                .sendKeys(Keys.SPACE)
//                .perform();

        String CountryCheck = wait.until(ExpectedConditions.visibilityOf(valueOfCountry)).getText();
        logger.info("Страна " + CountryCheck);
        return CountryCheck;
    }

    public String getCity() {
        String CityCheck = wait.until(ExpectedConditions.visibilityOf(valueOfCity)).getText();
        logger.info("Город " + CityCheck);
        return CityCheck;
    }

    public String getLanguage() {
        String LanguageCheck = wait.until(ExpectedConditions.visibilityOf(valueOfLanguageLevel)).getText();
        logger.info("Язык " + LanguageCheck);
        return LanguageCheck;
    }


    public String checkContacts(Integer i) {
        List<WebElement> contactValue = contactOptions;
        String contact = contactValue.get(i).getText();
        logger.info(contact);
        return contact;
    }


//    public String finalCheckContactOne() {
//
//        String contactOne = wait.until(ExpectedConditions.visibilityOf(contactOption)).getText();
//        logger.info(contactOne);
//        return contactOne;
//    }
//    public String finalCheckContactTwo() {
//
//        List<WebElement> contactTwoValue = contactOptions;
//        String contactTwo = contactTwoValue.get(1).getText();
//        logger.info(contactTwo);
//        return contactTwo;
//    }

}
