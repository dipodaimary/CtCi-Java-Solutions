package JavaBasics.FileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main2 {
    public static void main(String[] args) {
        Path sourceFile = Paths.get("1.txt");
        Path targetFile = Paths.get("2.txt");
        try {
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
