public class Main {
    public static void main(String[] args) {
        try {
            CommandLineOptions options = CommandLineOptions.parseArgs(args);
            FileProcessor processor = new FileProcessor(options);
            processor.processFiles();
            processor.printStatistics();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}