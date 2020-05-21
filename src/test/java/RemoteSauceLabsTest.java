import app.App;
import helpers.Driver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RemoteSauceLabsTest {

    /**
     * Set test name
     * Set test result
     * Close browser
     */
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Driver.executeJs("sauce:job-name=" + result.getName());
        Driver.executeJs("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
        Driver.close();
    }

    @Test
    public void loginRemote() {

        SoftAssert softAssert = new SoftAssert();

        App app = new App();

        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");

        softAssert.assertEquals(1,1);
        softAssert.assertEquals(1,2);
        softAssert.assertAll();
    }


    @Test
    public void loginRemote2() {

        SoftAssert softAssert = new SoftAssert();

        App app = new App();

        app.loginPage.open();
        app.loginPage.login("atcopybet1@yandex.ru", "test777");

        softAssert.assertEquals(1,1);
        softAssert.assertAll();
    }
}
