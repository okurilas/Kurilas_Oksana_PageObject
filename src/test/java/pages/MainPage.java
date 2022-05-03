package pages;

import config.IConfigServer;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private IConfigServer cfg = ConfigFactory.create(IConfigServer.class);

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open (){
        driver.get(cfg.urlOTUS());
    }
}
