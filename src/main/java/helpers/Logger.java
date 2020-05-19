package helpers;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

public class Logger {

    private static org.apache.log4j.Logger logger;

    public static void info(String message) {
        getLogger().info(message);
    }

    public static void warn(String message) {
        getLogger().warn(message);
    }

    public static void error(String message) {
        getLogger().error(message);
    }

    public static void fatal(String message) {
        getLogger().fatal(message);
    }

    private static org.apache.log4j.Logger getLogger() {
        if(logger == null) {
            logger = LogManager.getLogger("");
            DOMConfigurator.configure("src/main/resources/log4j.xml");
        }
        return logger;
    }
}
