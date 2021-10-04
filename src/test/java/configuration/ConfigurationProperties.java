package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static constants.Constants.CONFIGURATION_PROPERTIES;

public class ConfigurationProperties {
    private static Properties properties;

    static {
        try (FileInputStream fileInputStream = new FileInputStream(CONFIGURATION_PROPERTIES)){
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
