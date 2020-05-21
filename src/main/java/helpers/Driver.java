package helpers;

import app.AppConfig;
import com.codeborne.selenide.*;
import com.saucelabs.saucerest.SauceREST;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Driver {


    public static void initDriver() {

        // Get settings from command line

        TestConfig.initConfig();

        // Check if remote driver

        if(TestConfig.browser.contains("remote")) {
            initRemoteDriver();
            return;
        }

        // Set settings for selenide browser

        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
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
                break;
            case "firefox":
                Configuration.browser = Browsers.FIREFOX;
                break;
            default:
                Configuration.browser = Browsers.CHROME;
        }
    }

    public static void initRemoteDriver() {
        String host = "http://%s:%s@ondemand.eu-central-1.saucelabs.com/wd/hub";

        String browserName = "chrome";
        String browserVersion = "81.0";
        String platformName = "Windows 10";

        String sauceUser = "atcopybet1";
        String sauceKey = "776ed98f-1740-481f-afe1-bdbb88a918c7";

        String sauceUrl = String.format(host, sauceUser, sauceKey);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", platformName);
        capabilities.setCapability("screenResolution", "1920x1080");
//        capabilities.setCapability("recordVideo", false);
//        capabilities.setCapability("recordScreenshots", false);

        try {
            WebDriver driver = new RemoteWebDriver(new URL(sauceUrl),capabilities);
            WebDriverRunner.setWebDriver(driver);
            String sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
            SauceREST sauceClient = new SauceREST(sauceUser, sauceKey);
        } catch (MalformedURLException e) {}
    }

    public static WebDriver currentDriver() {
        return WebDriverRunner.getSelenideDriver().getWebDriver();
    }

    public static SelenideDriver currentSelenideDriver() {
        return WebDriverRunner.getSelenideDriver();
    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static void refresh() {
        Selenide.refresh();
    }

    public static void executeJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor)currentDriver();
        try {
            js.executeScript(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForUrlContains(String urlChunk) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), 10);
        wait.until(ExpectedConditions.urlContains(urlChunk));
    }

    public static void waitForUrlDoesNotContain(String urlChunk) {
        int maxTime = 20;
        while(  currentDriver().getCurrentUrl().contains(urlChunk)  && maxTime > 0) {
            wait(1);
            maxTime--;
        }
    }

    public static void maximize() {
        currentDriver().manage().window().maximize();
    }

    public static void changeWindowSize(int width, int height) {
        currentDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void clearCookies() {
        open(AppConfig.baseUrl);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    public static void close() {
        currentDriver().quit();
    }

    public static void wait(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshot() {

        File scrFile = ((TakesScreenshot) currentDriver()).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + " " + "screenshot_" +  (new SimpleDateFormat("HHmmssSSS").format(new Date())) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<LogEntry> getBrowserLogs() {
        LogEntries log = currentDriver().manage().logs().get("browser");
        List<LogEntry> logList = log.getAll();
        return logList;
    }

    // COOKIES

    public static void addCookie(Cookie cookie) {
        currentDriver().manage().addCookie(cookie);
    }

    public static Cookie getCookie(String cookieName) {
        return currentDriver().manage().getCookieNamed(cookieName);
    }

    public static void deleteCookie(String cookieName) {
        currentDriver().manage().deleteCookieNamed(cookieName);
    }

}
