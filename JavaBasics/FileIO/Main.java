package JavaBasics.FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        String sourceFile = "1.txt";
        String targetFile = "2.txt";
        try (
                FileReader fReader = new FileReader(sourceFile);
                BufferedReader bReader = new BufferedReader(fReader);
                FileWriter fileWriter = new FileWriter(targetFile)
        ) {
            while (true) {
                String line = bReader.readLine();
                if (line == null) {
                    break;
                } else {
                    fileWriter.write(line + '\n');
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
