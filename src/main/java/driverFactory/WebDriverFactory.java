package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import javax.annotation.Nullable;

public class WebDriverFactory {

    private Browsers nameOfBrowser;

    public Browsers getNameOfBrowser() {
        return nameOfBrowser;
    }

//    public void setNameOfBrowser(Browsers nameOfBrowser) {
//        this.nameOfBrowser = nameOfBrowser;
//    }

    public static WebDriver getDriver(Browsers nameOfBrowser, ChromeOptions... options) {


        switch (nameOfBrowser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver();

            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

        }
    }
}

//    Создайте класс WebDriverFactory со статическим методом create();
//    Метод create() принимает обязательный параметр webDriverName и необязтельный параметр options,
//    а возвращает соответствующий имени вебдрайвер с заданными (если были) options
//        Примеры использования
//        WebDriver wd = WebDriverFactory.createNewDriver("chrome");
//        или
//        FirefoxOptions options = new FirefoxOptions();
//        WebDriver wd = WebDriverFactory.createNewDriver("firefox", options);


//    public static WebDriver getDriver(String driverName) {
//
//
//
//            switch (driverName) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    return new ChromeDriver();
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    return new FirefoxDriver();
//                case "ie":
//                    WebDriverManager.iedriver().setup();
//                    return new InternetExplorerDriver();
//                case "opera":
//                    WebDriverManager.operadriver().setup();
//                    return new OperaDriver();
//
//                default:
//                    WebDriverManager.chromedriver().setup();
//                    return new ChromeDriver();
//
//            }
//        }




