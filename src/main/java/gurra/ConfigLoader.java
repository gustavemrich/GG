package gurra;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ConfigLoader {

    public static Map<String, Object> loadConfig(String fileName) {
        Yaml yaml = new Yaml();
        Path path = Paths.get(fileName);

        try (InputStream inputStream = Files.newInputStream(path)) {
            return yaml.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


