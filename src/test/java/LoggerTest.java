import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import java.util.List;

public class LoggerTest {

    @Test
    public void testLogger()
    {
        org.apache.log4j.Logger logger = LogManager.getLogger("");
        DOMConfigurator.configure("src/main/resources/log4j.xml");

        logger.info("Sample info message");
        logger.warn("Sample warn message");
        logger.error("Sample error message");
        logger.fatal("Sample fatal message");

        // My wrapper for logger

        helpers.Logger.info("my logger");
        helpers.Logger.warn("my logger");
        helpers.Logger.error("my logger");
        helpers.Logger.fatal("my logger");
    }


}
