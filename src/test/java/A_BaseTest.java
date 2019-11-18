import app.App;

import helpers.DriverHelper;
import helpers.TestConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;



class A_BaseTest {

    protected App app;
    protected SoftAssert softAssert;

    @BeforeClass
    public void init() {
        TestConfig.initConfig();
        softAssert = new SoftAssert();

        app = new App();
    }

    @AfterMethod
    public void clearCookies() {
        DriverHelper.clearCookies();
    }

    @AfterClass
    public void closeBrowser() {
        DriverHelper.quit();
    }
}
