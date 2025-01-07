import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileProcessor {
    private final CommandLineOptions options;
    private final Map<String, List<String>> data = new HashMap<>();
    private final StatisticsCollector stats = new StatisticsCollector();

    public FileProcessor(CommandLineOptions options) {
        this.options = options;
        data.put("integers", new ArrayList<>());
        data.put("floats", new ArrayList<>());
        data.put("strings", new ArrayList<>());
    }

    public void processFiles() {
        for (String fileName : options.files) {
            processFile(fileName);
        }
        writeData();
    }

    private void processFile(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                classifyData(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
        }
    }

    private void classifyData(String line) {
        try {
            if (line.matches("\\d+")) {
                // Проверяем, может ли это быть Long
                long value = Long.parseLong(line);
                data.get("integers").add(line);
                stats.update("integers", value);
            } else if (line.matches("[+-]?\\d*\\.\\d+([eE][+-]?\\d+)?")) {
                double value = Double.parseDouble(line);
                data.get("floats").add(line);
                stats.update("floats", value);
            } else {
                data.get("strings").add(line);
                stats.update("strings", line);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error processing line: " + line + " (not a valid number)");
        }
    }

    private void writeData() {
        DataWriter writer = new DataWriter(options);
        data.forEach((type, values) -> {
            if (!values.isEmpty()) {
                writer.writeToFile(type, values);
            }
        });
    }

    public void printStatistics() {
        stats.print(options.fullStatistics);
    }
}