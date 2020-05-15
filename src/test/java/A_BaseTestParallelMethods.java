import helpers.Driver;
import helpers.TestConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

/**
 * Browser is closed after every test method
 */
class A_BaseTestParallelMethods {

    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        softAssert = new SoftAssert();
    }

}
