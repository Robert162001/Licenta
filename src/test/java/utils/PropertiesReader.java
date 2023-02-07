package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class PropertiesReader {

    private static final String TEST_PROPERTIES = "src/test/resources/test.properties";

    public enum TestProperty {BASE_URL}

    public static String getProperty(TestProperty property) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(TEST_PROPERTIES));
        } catch (IOException fie) {
            fie.printStackTrace();
        }
        return properties.getProperty(property.toString().toLowerCase(Locale.ROOT));
    }
}
