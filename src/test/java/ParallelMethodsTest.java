import app.App;
import org.testng.annotations.Test;

public class ParallelMethodsTest extends A_BaseTestParallelMethods
{
    @Test
    public void login() {
        App app = new App();

        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");

        softAssert.assertEquals(1,1);
        softAssert.assertEquals(1,2);
        softAssert.assertAll();
    }

    @Test
    public void openLoginPage() {
        App app = new App();

        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");

        softAssert.assertEquals(1,1);
        softAssert.assertEquals(1,2);
        softAssert.assertAll();
    }

}
