package helpers;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;

public class DriverContainer {
    private static HashMap<Integer, WebDriver> drivers = new HashMap<Integer, WebDriver>();

    public static WebDriver getCurrentDriver() {
        Integer threadId = (int)Thread.currentThread().getId();
        if(drivers.get(threadId) != null) {
            return drivers.get(threadId);
        } else {
            initDriver();
            return drivers.get(threadId);
        }
    }

    private static void initDriver() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;
        Configuration.screenshots = false;

        switch (TestConfig.browser)
        {
            case "chrome":
                Configuration.browser = Browsers.CHROME;
                Selenide.open("http://google.com");
                addDriver( WebDriverRunner.getSelenideDriver().getWebDriver());
                break;

            case "firefox":
                Configuration.browser = Browsers.FIREFOX;
                Selenide.open("http://google.com");
                addDriver( WebDriverRunner.getSelenideDriver().getWebDriver());
                break;

            default:
                Configuration.browser = Browsers.CHROME;
                Selenide.open("http://google.com");
                addDriver( WebDriverRunner.getSelenideDriver().getWebDriver());

//            case "chrome":
//
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--headless", "--disable-gpu", "--ignore-certificate-errors", "--silent", "--hide-scrollbars");
//
//                addDriver(new ChromeDriver(chromeOptions));
//                break;
//
//            case "firefox":
//
//                WebDriverManager.firefoxdriver().setup();
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.setHeadless(true);
//
//                addDriver(new FirefoxDriver(firefoxOptions));
//                break;
        }
    }

    public static void addDriver(WebDriver driver) {
        Integer threadId = (int)Thread.currentThread().getId();
        drivers.put(threadId, driver);
    }

    public static void removeDriver() {
        Integer threadId = (int)Thread.currentThread().getId();
        drivers.remove(threadId);
    }

    public static void executeJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor) DriverContainer.getCurrentDriver();
        try {
            js.executeScript(script);
        } catch (Exception e) {}
    }

}
