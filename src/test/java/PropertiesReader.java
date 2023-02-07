import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {
    public static void main(String[] args) {
        Properties properties = new Properties();
        java.net.URL url = ClassLoader.getSystemResource("base.properties");

        try {
            properties.load(url.openStream());
        } catch (IOException fie) {
            fie.printStackTrace();
        }
        System.out.println(properties.getProperty("hostname"));
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(key + " - " + properties.getProperty(key));
        }
    }
}
