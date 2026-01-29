import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;




public class Config {
    // This class will hold configuration and path-building logic for Kovaaks randomizer

    private static final String KOVAAKS_PATH_FILE = "kovaaks-path.txt";
    public static Path getConfigDir() {
        String userHome = System.getProperty("user.home");
        return Paths.get(userHome, ".kovaaks-randomizer");


    }

    // Reads the saved Kovaaks root path from the config file.
    public static String getKovaaksPath() {
        Path configDir = getConfigDir();
        Path pathFile = configDir.resolve(KOVAAKS_PATH_FILE);

        if (!Files.exists(pathFile)) {
            return null;
        }
        try {
            String content = Files.readString(pathFile);
            String trimmed = content.trim();
            return trimmed.isEmpty() ? null : trimmed;
        } catch (Exception e) {
            return null;
        }
    

    }   

    // This saves the Kovaaks root path to the Config file.

public static void saveKovaaksPath(String path) {
        if (path == null || path.isEmpty()) {
        return;
        }
        try {
        Path configDir = getConfigDir();
        Files.createDirectories(configDir);
        Path pathFile = configDir.resolve(KOVAAKS_PATH_FILE);
        Files.writeString(pathFile, path.trim());
        } catch (Exception e) {
            // For now, we ignore the error, add a error message popup later.
        }
    }
}