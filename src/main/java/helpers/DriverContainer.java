package helpers;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;


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
        Configuration.screenshots = false;

        if(TestConfig.isHeadless()) {
            Configuration.headless = true;
        } else {
            Configuration.headless = false;
        }

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
}
