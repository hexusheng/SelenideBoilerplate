package helpers;

public class TestConfig {

    public static String browser = "chrome";
    public static String headless = "0";

    public static void initConfig()
    {
        browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        headless = System.getProperty("headless") == null ? "1" : System.getProperty("headless");
    }

}
