import helpers.Driver;
import org.testng.annotations.Test;

public class ParallelClassOneTest extends A_BaseTestParallelClasses {

    @Test
    public void login() {
        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");

        softAssert.assertEquals(1,1);
        softAssert.assertAll();
    }



}
