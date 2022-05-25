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

    public void enterLogin (String UserLogin){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn))
                .click();
        wait.until(ExpectedConditions.visibilityOf(loginField));
        wait.until(ExpectedConditions.visibilityOf(pwdField));

        logger.info("Ввод логина");
        loginField
                .sendKeys(UserLogin);
    }

    public void enterPWD (String UserPWD){
        logger.info("Ввод пароля");
        pwdField
                .sendKeys(UserPWD);
        loginButton
                .submit();
    }

    public void clickLoginBtn (){
        logger.info("Нажимаем ЛОГИН");
        loginButton
                .submit();
    }

    public UserPage login (String UserLogin, String UserPWD){
        logger.info("Авторизация");
        enterLogin(UserLogin);
        enterPWD(UserPWD);
        clickLoginBtn();
        return new UserPage(driver,wait);
    }

}
