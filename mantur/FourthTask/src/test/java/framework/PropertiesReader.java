package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static Properties prop = new Properties();

    private static File resourcesDir = new File("src/test/resources/");

    public static String getResourcesPath() {
        return resourcesDir.getAbsolutePath();
    }

    private PropertiesReader() {
        try {
            prop.load(new FileInputStream(getResourcesPath() + "/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static PropertiesReader pr = new PropertiesReader();

    public static String getBrowser() {
        return prop.getProperty("browser");
    }

    public static String getUrl() {
        return prop.getProperty("url");
    }

    public static int getTimeOut() {
        return Integer.parseInt(prop.getProperty("timeout"));
    }
}
