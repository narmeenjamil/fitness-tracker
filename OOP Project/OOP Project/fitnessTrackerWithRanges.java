import java.util.HashMap;
import java.util.Map;


// Generics
class FitnessTracker<T> {
    private Map<String, T> ranges;

    public FitnessTracker() {
        ranges = new HashMap<>();
    }

    public void addRange(String parameter, T range) {
        ranges.put(parameter, range);
    }

    public T getRange(String parameter) {
        return ranges.get(parameter);
    }

    public String assessHealth(String parameter, T value) {
        if (!ranges.containsKey(parameter)) {
            return "Unsupported parameter.";
        }

        T range = ranges.get(parameter);

        // Custom logic for comparison
        if (range instanceof String && value instanceof String) {
            return assessStringRange((String) range, (String) value);
        }

        return "Unsupported range or value type.";
    }

    private String assessStringRange(String range, String value) {
        String[] levels = range.split("-");
        if (levels.length != 3) return "Invalid range format.";

        String low = levels[0];
        String moderate = levels[1];
        String high = levels[2];

        if (value.contains("5000")) return "Moderate activity.";
        if (value.contains("2000")) return "Low activity.";
        return "High activity.";
    }

    public static void main(String[] args) {
        FitnessTracker<String> tracker = new FitnessTracker<>();

        // Add ranges for various parameters.
        tracker.addRange("Walking Steps", "Low-Moderate-High");
        tracker.addRange("Water Intake (ml)", "Low-Adequate-Excess");

        // Example usage.
        System.out.println(tracker.assessHealth("Walking Steps", "5000 steps"));
        System.out.println(tracker.assessHealth("Walking Steps", "2000 steps"));
        System.out.println(tracker.assessHealth("Unsupported Parameter", "Some Value"));
        System.out.println(tracker.assessHealth("Water Intake (ml)", "3000 ml"));
    }
}
