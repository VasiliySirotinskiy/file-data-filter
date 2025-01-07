import java.util.*;

public class StatisticsCollector {
    private final Map<String, List<Object>> stats = new HashMap<>();

    public void update(String type, Object value) {
        stats.computeIfAbsent(type, k -> new ArrayList<>()).add(value);
    }

    public void print(boolean full) {
        stats.forEach((type, values) -> {
            System.out.println(type.toUpperCase() + " STATISTICS");
            System.out.println("Count: " + values.size());
            if (full) {
                if (type.equals("integers") || type.equals("floats")) {
                    List<Number> numbers = values.stream().map(v -> (Number) v).toList();
                    double min = numbers.stream().mapToDouble(Number::doubleValue).min().orElse(0);
                    double max = numbers.stream().mapToDouble(Number::doubleValue).max().orElse(0);
                    double sum = numbers.stream().mapToDouble(Number::doubleValue).sum();
                    double avg = sum / numbers.size();
                    System.out.println("Min: " + min + ", Max: " + max + ", Sum: " + sum + ", Avg: " + avg);
                } else if (type.equals("strings")) {
                    int minLength = values.stream().mapToInt(v -> v.toString().length()).min().orElse(0);
                    int maxLength = values.stream().mapToInt(v -> v.toString().length()).max().orElse(0);
                    System.out.println("Min Length: " + minLength + ", Max Length: " + maxLength);
                }
            }
        });
    }
}