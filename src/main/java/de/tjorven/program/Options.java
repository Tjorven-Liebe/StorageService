package de.tjorven.program;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Options {
    private final Map<String, String> settings = new HashMap<>();

    public Options() {
        try {
            this.settings.putAll(loadSettingsFrom("options.properties", "Programm Options"));
            this.settings.putAll(loadSettingsFrom("options1.properties", "Programm Options 1"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> loadSettingsFrom(String propertiesFile, String comments) throws IOException {
        final Properties properties = new Properties();
        File file = new File(propertiesFile);
        if (!file.exists()) {
            properties.load(getClass().getClassLoader().getResourceAsStream(propertiesFile));
            if (file.getParentFile() != null) file.getParentFile().mkdirs();
            file.createNewFile();
            properties.store(new FileWriter(propertiesFile), comments);
        } else
            properties.load(new FileReader(file));
        final Map<String, String> props = new HashMap<>();
        properties.forEach((key, value) -> {
            if (key instanceof String key1 && value instanceof String value1) props.put(key1, value1);
        });
        return props;
    }

    public Map<String, String> getSettings() {
        return settings;
    }
}
