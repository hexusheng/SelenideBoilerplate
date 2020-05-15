import app.App;
import helpers.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

class A_BaseTestParallelClasses {

    protected App app;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        app = new App();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void clearCookies() {
        Driver.clearCookies();
    }

    @AfterClass
    public void tearDown() {
        Driver.quit();
    }
}
