package pages;

import config.IConfigServer;
import driverFactory.WebDriverFactory;
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

//    @FindBy (css = ".header2__logo")
//    private WebElement  otusHeader;
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

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }

//    public WebElement open (){
//        driver.get(cfg.urlOTUS());
//        WebElement headerOTUS = wait.until(ExpectedConditions.elementToBeClickable(otusHeader));
//        return headerOTUS;
//    }

//    public void init (){
////        driver = WebDriverFactory.getDriver("chrome");
////        logger.info("драйвер поднят");
////        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        actions = new Actions(driver);
//    }

    public WebElement login (String UserLogin, String UserPWD){

        logger.info("Авторизация");

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn))
                .click();
        wait.until(ExpectedConditions.visibilityOf(loginField));
        wait.until(ExpectedConditions.visibilityOf(pwdField));

        loginField
                .sendKeys(UserLogin);//.sendKeys("oksana777@list.ru");//.sendKeys(cfg.login());
        pwdField
                .sendKeys(UserPWD);//.sendKeys("Caiman123!");//.sendKeys(cfg.pwd());
        loginButton
                .submit();

        WebElement avatarPic = wait.until(ExpectedConditions.visibilityOf(avatar));
        logger.info("Авторизация прошла успешно");
        return avatarPic;

    }
}
