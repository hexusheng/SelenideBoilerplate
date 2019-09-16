import app.App;
import app.AppConfig;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    protected App app;

    @BeforeClass
    public void init() {
        Configuration.browser = Browsers.CHROME;
        Configuration.browserSize = "1920x1080";
        //Configuration.headless = true;
    }

    @BeforeMethod
    public void initApp() {
        app = new App();
    }

    @AfterMethod
    public void clearCookies() {
        open(AppConfig.baseUrl);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void test1() {
        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");

    }

    @Test
    public void test2() {
        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");
    }
}
