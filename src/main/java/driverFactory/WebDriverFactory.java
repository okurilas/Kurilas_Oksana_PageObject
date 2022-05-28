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
import java.util.List;

public class WebDriverFactory {

    //private Browsers nameOfBrowser;

//    public Browsers getNameOfBrowser() {
//        return nameOfBrowser;
//    }



    public static WebDriver getDriver(Browsers nameOfBrowser) {
    //public static WebDriver getDriver(Browsers nameOfBrowser, ChromeOptions... options) {
//public static WebDriver getDriver(Browsers nameOfBrowser, List<String> options) {

        switch (nameOfBrowser) {
//            case CHROME:
//                //ChromeOptions chromeOptions = new ChromeOptions();
//                //chromeOptions.addArguments(chromeOptions);
//                WebDriverManager.chromedriver().setup();
//                //return new ChromeDriver(chromeOptions);
//                return new ChromeDriver();
            case FIREFOX:
                //FirefoxOptions firefoxOptions = new FirefoxOptions();
                //firefoxOptions.addArguments(options);
                WebDriverManager.firefoxdriver().setup();
                //return new FirefoxDriver(firefoxOptions);
                return new FirefoxDriver();
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case OPERA:
                //OperaOptions operaOptions = new OperaOptions();
                //operaOptions.addArguments(options);
                WebDriverManager.operadriver().setup();
                //return new OperaDriver(operaOptions);
                return new OperaDriver();

            default:
                //chromeOptions = new ChromeOptions();
                //chromeOptions.addArguments(options);
                WebDriverManager.chromedriver().setup();
                //return new ChromeDriver(chromeOptions);
                return new ChromeDriver();

        }
    }
}





