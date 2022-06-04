package pages;

import config.IConfigServer;
import enums.Cities;
import enums.Countries;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
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

public class LKPage extends BasePage{



    @FindBy(xpath = "//a[contains(text(),'О себе')]")
    private WebElement aboutMe;

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

    @FindBys(@FindBy(css = "div.input_straight-bottom-right"))
    private List<WebElement> contactOptions;

    @FindBys(@FindBy(xpath = "//button[@data-empty='Способ связи']//../following-sibling::button"))
    private List<WebElement> typeOfContact;

    @FindBys(@FindBy(css ="input.input.input_straight-top-left.input_straight-bottom-left.lk-cv-block__input.lk-cv-block__input_9.lk-cv-block__input_md-8"))
    private List<WebElement> contactValue;

    @FindBy(id = "id_contact-0-value")
    private WebElement contactValueOne;
    @FindBy(id = "id_contact-1-value")
    private WebElement contactValueTwo;

    @FindBy(xpath = "//div[contains(@class,'js-formset-row')]")
    private List<WebElement> contactContainer;

    @FindBys(@FindBy(xpath ="//div[@data-prefix='contact']/child::div/child::div/child::div/child::div/child::div/child::input"))
    private List<WebElement> existingContact;

    @FindBy(xpath = "//div[@data-prefix='contact']/child::div/child::div/child::*/child::*/child::button")
    private WebElement delete;
    @FindBys(@FindBy(xpath = "//div[@data-prefix='contact']/child::div/child::div/child::*/child::*/child::button"))
    private List<WebElement> deleteC;
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement add;
    @FindBy(xpath = "//button[contains(text(),'Сохранить и продолжить')]")
    private WebElement save;

    @FindBy(xpath = "//input[@name='country']/following-sibling::div")
    private WebElement countryField;
    @FindBy(xpath = "//div[contains(@class,'lk-cv-block__select-scroll_country')]")
    private WebElement countrySelectField;
    @FindBy(xpath = "//input[@name='city']/following-sibling::div")
    private WebElement cityField;
    @FindBy(xpath = "//div[contains(@class,'lk-cv-block__select-scroll_city')]")
    private WebElement citySelectField;

    public LKPage(WebDriver driver) {
        super(driver);
    }

    public void openAboutMeSection() {
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
    }

    public void changeAddress() {

        logger.info("Редактируем Основную информацию");

        logger.info("Вводим Страну");
        wait.until(ExpectedConditions.elementToBeClickable(country))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(countryValue))
                .click();
        logger.info("Вводим Город");
        wait.until(ExpectedConditions.elementToBeClickable(city))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(cityValue))
                .click();
        logger.info("Вводим Уровень английского");
        wait.until(ExpectedConditions.elementToBeClickable(languageLevel))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(languageLevelValue))
                .click();
    }

    public void deleteContacts(Integer i){
        logger.info("Удаляем контакты " + i);
        for (i = 0; i < deleteC.size()-1; i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(deleteC)).get(i).click();
        }
    }

    public void deleteContactt() {
        logger.info("Удаляем контакт");
        wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
    }

    public void deleteExistingContacts() {
        List<WebElement> existingContacts = contactContainer;
        logger.info("существующие контакты = " + existingContacts.size());
        if (CollectionUtils.isNotEmpty(existingContacts)) {
            for (WebElement existingContact : existingContacts) {
                deleteContact(existingContact);
                logger.info("Удалили контакт");
            }
        }
    }


    private void deleteContact(WebElement contact) {
        final By deleteContainerButton = By.xpath(".//div[(contains(@class,'container__col') and contains(@class,'container__col_12') and contains(@class,'container__col_md-0'))]");
        final By deleteBtn = By.xpath(".//button[contains(@class, 'js-formset-delete')]");
        WebElement deleteButtonDiv = contact.findElement(deleteContainerButton);
        deleteButtonDiv.findElement(deleteBtn).click();
    }

    public List <WebElement> checkExistingContacts(){
        logger.info("Проверяем существующие контакты");
        logger.info("Контактов = " + wait.until(ExpectedConditions.visibilityOfAllElements(existingContact)).size());
        return wait.until(ExpectedConditions.visibilityOfAllElements(existingContact));
    }

    public  void addContact() {
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
        wait.until(ExpectedConditions.elementToBeClickable(save))
                .click();
    }

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

    public void setCountryAndCity() {
        Countries configCountry = cfg.country();
        Cities configCity  = cfg.city();        //
        assert configCountry.equals(configCity.getCountry()) : "Такого города нет в этой стране";
        countryField.click();
        countrySelectField.findElement(By.xpath(String.format("button[@title='%s']", configCountry.getTranslate()))).click();
        wait.until(ExpectedConditions.textToBePresentInElement(cityField,"Город"));
        cityField.click();
        citySelectField.findElement(By.xpath(String.format("button[@title='%s']", configCity.getTranslate()))).click();
    }
    public void checkCountryField() {
        Countries configCountry = cfg.country();
        Cities configCity = cfg.city();
        String getCountry = countryField.getText();
        String getCity = cityField.getText();
        Assert.assertEquals(configCountry.getTranslate(), getCountry);
        Assert.assertEquals(configCity.getTranslate(), getCity);
    }

}
