package pages;

import config.IConfigServer;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    //private WebDriver driver;
    //private IConfigServer cfg = ConfigFactory.create(IConfigServer.class);
    //private Logger logger = LogManager.getLogger(LoginPage.class);
    //private WebDriverWait wait;
    //private Actions actions;

    @FindBy (css = ".header2__logo")
    private WebElement  otusHeader;
    @FindBy (xpath = "//button[contains(text(),'Вход')]")
    private WebElement loginBtn;
    @FindBy (css = ".js-login input[name='email']")
    private WebElement loginField;
    @FindBy (xpath = "//input[@type='password']")
    private WebElement pwdField;
    @FindBy (xpath = "//button[contains(text(),'Войти')]")
    private WebElement loginButton;
    @FindBy (css = "div.header2-menu__icon-img.ic-blog-default-avatar")
    private WebElement avatar;


//    private By loginBtn = By.xpath("//button[contains(text(),'Вход')]");
//    private By loginField = By.cssSelector(".js-login input[name='email']");
//    private By pwdField = By.xpath("//input[@type='password']");
//    private By loginButton = By.xpath("//button[contains(text(),'Войти')]");
//    private By avatar = By.cssSelector("div.header2-menu__icon-img.ic-blog-default-avatar");



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement open (){
        //driver = new ChromeDriver();//////////////////////////////////////////
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));/////////////////////////////
        driver.get(cfg.urlOTUS());
        WebElement headerOTUS = wait.until(ExpectedConditions.elementToBeClickable(otusHeader));
        return headerOTUS;

        //Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(otusHeader)).isEnabled());
    }


//    public LoginPage openn (){
//        driver.get(cfg.urlOTUS());
//        return this;
//    }



    public void init (){
        driver = new ChromeDriver();
        logger.info("драйвер поднят");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    public WebElement login (){

        logger.info("Авторизация");
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));///////////////////////////////////////


        wait.until(ExpectedConditions.elementToBeClickable(loginBtn))
                .click();
        wait.until(ExpectedConditions.visibilityOf(loginField));
        wait.until(ExpectedConditions.visibilityOf(pwdField));

//        driver.findElement(loginField)
//                .sendKeys(cfg.login());//.sendKeys("oksana777@list.ru");//.sendKeys(cfg.login());
//        driver.findElement(pwdField)
//                .sendKeys(cfg.pwd());//.sendKeys("Caiman123!");//.sendKeys(cfg.pwd());
//        driver.findElement(loginButton)
//                .submit();

        loginField
                .sendKeys(cfg.login());//.sendKeys("oksana777@list.ru");//.sendKeys(cfg.login());
        pwdField
                .sendKeys(cfg.pwd());//.sendKeys("Caiman123!");//.sendKeys(cfg.pwd());
        loginButton
                .submit();

        WebElement avatarPic = wait.until(ExpectedConditions.visibilityOf(avatar));
        //Assert.assertTrue((avatarPic).isDisplayed());
        logger.info("Авторизация прошла успешно");
        return avatarPic;

    }

//    public UserPage loginn (){
//
//        logger.info("Авторизация");
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));///////////////////////////////////////
//
//
//        wait.until(ExpectedConditions.elementToBeClickable(loginBtn))
//                .click();
//        wait.until(ExpectedConditions.and(
//                ExpectedConditions.presenceOfElementLocated(loginField),
//                ExpectedConditions.presenceOfElementLocated(pwdField)
//        ));
//        driver.findElement(loginField)
//                .sendKeys(cfg.login());//.sendKeys("oksana777@list.ru");//.sendKeys(cfg.login());
//        driver.findElement(pwdField)
//                .sendKeys(cfg.pwd());//.sendKeys("Caiman123!");//.sendKeys(cfg.pwd());
//        driver.findElement(loginButton)
//                .submit();
//
//        WebElement avatarPic = wait.until(ExpectedConditions.presenceOfElementLocated(avatar));
//        Assert.assertTrue((avatarPic).isDisplayed());
//        logger.info("Авторизация прошла успешно");
//        return new UserPage(driver);
//
//    }
}
