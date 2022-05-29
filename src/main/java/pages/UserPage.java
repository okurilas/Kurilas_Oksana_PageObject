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

    public UserPage(WebDriver driver) {
       super(driver);
    }

    public LKPage openLK(){

        logger.info("Открыть Личный кабинет");

        wait.until(ExpectedConditions.elementToBeClickable(username))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(lk))
                .click();
        String text = wait.until(ExpectedConditions.visibilityOf(lkTitle))
                .getText();
        return new LKPage(driver);
    }

}
