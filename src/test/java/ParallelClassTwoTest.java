import org.testng.annotations.Test;

public class ParallelClassTwoTest extends A_BaseTestParallelClasses {

    @Test
    public void login() {
        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");

        softAssert.assertEquals(1,2);
        softAssert.assertAll();
    }
}
