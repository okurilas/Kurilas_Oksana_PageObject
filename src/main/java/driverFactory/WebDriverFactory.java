package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class WebDriverFactory {

    public static WebDriver getDriver(Browsers nameOfBrowser,List<String>... options) {

        switch (nameOfBrowser) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(Arrays.toString(options));
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case OPERA:
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.addArguments(Arrays.toString(options));
                WebDriverManager.operadriver().setup();
                return new OperaDriver(operaOptions);
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(String.valueOf(options));
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
        }
    }
}





