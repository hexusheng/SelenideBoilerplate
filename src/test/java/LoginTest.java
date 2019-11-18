import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends A_BaseTest
{

    @Test
    @Description("Авторизация через email")
    @Severity(SeverityLevel.CRITICAL)
    public void loginViaEmail() {
        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");
    }

//    @Test(dataProvider="getData")
//    public void instanceDbProvider(int p1, String p2) {
//        System.out.println("Instance DataProvider Example: Data(" + p1 + ", " + p2 + ")");
//    }
//
//    @DataProvider
//    public Object[][] getData() {
//        return new Object[][]{{5, "five"}, {6, "six"}};
//    }

}
