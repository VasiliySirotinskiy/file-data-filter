import java.util.*;

public class CommandLineOptions {
    String outputPath = ".";
    String prefix = "";
    boolean append = false;
    boolean fullStatistics = false;
    List<String> files = new ArrayList<>();

    static CommandLineOptions parseArgs(String[] args) {
        CommandLineOptions options = new CommandLineOptions();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    options.outputPath = args[++i];
                    break;
                case "-p":
                    options.prefix = args[++i];
                    break;
                case "-a":
                    options.append = true;
                    break;
                case "-f":
                    options.fullStatistics = true;
                    break;
                case "-s":
                    options.fullStatistics = false;
                    break;
                default:
                    options.files.add(args[i]);
            }
        }
        if (options.files.isEmpty()) {
            throw new IllegalArgumentException("No input files provided!");
        }
        return options;
    }
}