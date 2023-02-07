package utils;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PropertiesReader {

    private static final String TEST_PROPERTIES = "test.properties";

    public enum TestProperty {BASE_URL, USERNAME}

    public static String getProperty(TestProperty property) {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResource(TEST_PROPERTIES).openStream());
        } catch (IOException fie) {
            fie.printStackTrace();
        }
        return properties.getProperty(property.toString().toLowerCase(Locale.ROOT));
    }
}
