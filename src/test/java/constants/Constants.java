package constants;

import configuration.ConfigurationProperties;
import org.apache.commons.lang3.RandomStringUtils;

public final class Constants {
    private Constants() {
    }

    public static final int LENGTH = 6;
    public static final boolean USE_LETTERS = true;
    public static final String CREATED_FIRST_NAME = RandomStringUtils.random(LENGTH, String.valueOf(USE_LETTERS));
    public static final String CREATED_LAST_NAME = RandomStringUtils.random(LENGTH, String.valueOf(USE_LETTERS));
    public static final String CREATED_PHONE = RandomStringUtils.randomNumeric(9);
    public static final String CREATED_EMAIL = RandomStringUtils.random(LENGTH, String.valueOf(USE_LETTERS)) + "@gmail.com";

    public static final String BASE_URL = ConfigurationProperties.getProperty("baseUrl");

    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String ID = "id";
    public static final String NAME = "name";

    public static final String CONFIGURATION_PROPERTIES = "src/test/resources/configuration.properties";
}
