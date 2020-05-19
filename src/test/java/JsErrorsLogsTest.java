import app.App;
import helpers.Driver;
import helpers.Logger;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JsErrorsLogsTest {

    @Test
    public void jsErrorTest() {

        SoftAssert softAssert = new SoftAssert();

        Driver.initDriver();
        Driver.open("http://the-internet.herokuapp.com/javascript_error");

        List<LogEntry> logs = Driver.getBrowserLogs();

        // Verifying there are no JavaScript errors in console
        for (LogEntry logEntry : logs) {

            if (logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }

            // Log js errors

            Logger.info(logEntry.getMessage());

        }

        softAssert.assertAll();
    }
}
