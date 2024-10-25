package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;

    public ConfigManager() {
        properties = new Properties();
        try {
            // Load the properties file
            FileInputStream fis = new FileInputStream("src/test/java/Config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    // Method to retrieve property values by key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
