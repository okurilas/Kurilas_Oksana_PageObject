package pages;

import config.IConfigServer;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    public IConfigServer cfg = ConfigFactory.create(IConfigServer.class);
    protected Logger logger = LogManager.getLogger(LoginPage.class);
    public WebDriverWait wait;
    protected Actions actions;

    @FindBy(css = ".header2__logo")
    private WebElement  otusHeader;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }

    public WebElement open (){
        driver.get(cfg.urlOTUS());
        return wait.until(ExpectedConditions.visibilityOf(otusHeader));
    }



}
