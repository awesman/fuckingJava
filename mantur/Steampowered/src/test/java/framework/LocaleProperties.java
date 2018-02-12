package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocaleProperties {

    private static final String PATH_RU_LOCALE = "src/test/resources/localization/loc_RU.properties";
    private static final String PATH_EN_LOCALE = "src/test/resources/localization/loc_EN.properties";
    private Properties properties;


    public LocaleProperties(String locale) {
        String path;
        switch (Locale.valueOf(locale.trim().toUpperCase())) {
            case EN:
                path = PATH_EN_LOCALE;
                break;
            case RU:
                path = PATH_RU_LOCALE;
                break;
            default:
                throw new RuntimeException("Locale not supported");
        }
        init(path);
    }

    private void init(String path) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    private enum Locale {
        RU, EN
    }
}
