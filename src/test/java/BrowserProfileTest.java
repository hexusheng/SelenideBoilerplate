import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserProfileTest {


    @Test
    public void test() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/home/alex/at/SelenideBoilerplate/src/test/resources/browser_profiles/Profile_1");
        options.addArguments("--start-maximized");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        WebDriverRunner.setWebDriver(driver);

        Selenide.open("http://ya.ru");
        WebDriverRunner.getWebDriver().close();
    }
}
