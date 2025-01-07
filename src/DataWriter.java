import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataWriter {
    private final CommandLineOptions options;

    public DataWriter(CommandLineOptions options) {
        this.options = options;
    }

    public void writeToFile(String type, List<String> values) {
        String fileName = String.format("%s/%s%s.txt", options.outputPath, options.prefix, type);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName),
                options.append ? StandardOpenOption.APPEND : StandardOpenOption.CREATE)) {
            for (String value : values) {
                writer.write(value);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
        }
    }
}