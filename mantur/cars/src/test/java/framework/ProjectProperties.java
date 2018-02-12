package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {

    private static final String PROPERTIES_PATH = "src/test/resources/application.properties";
    private static Properties properties;

    static {
        init();
    }

    private static void init() {
        properties = new java.util.Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}

