import app.App;
import helpers.CsvDataProvider;
import helpers.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class CsvDataProviderTest {

    @BeforeMethod
    public void clearCookies() {
        Driver.initDriver();
        Driver.clearCookies();
    }

    @DataProvider(name = "csvProvider")
    public Object[][] testData() throws IOException
    {
        return CsvDataProvider.getCsvData("data_provider");
    }

    @Test(dataProvider = "csvProvider")
    public void csvDataProviderTest(String username, String password) {
        App app = new App();
        app.loginPage.open();
        app.loginPage.login(username, password);
    }

}
