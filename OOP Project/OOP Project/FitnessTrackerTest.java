
// Test cases

public class FitnessTrackerTest {
    public static void main(String[] args) {
        FitnessTrackerWithRanges tracker = new FitnessTrackerWithRanges();

        // Test Case 1: Assess Walking Steps (Low Activity)
        String result1 = tracker.assessHealth("Walking Steps", "1000 steps");
        assert result1.equals("Low activity. Increase daily steps.") : "Test Case 1 Failed";

        // Test Case 2: Assess Walking Steps (Moderate Activity)
        String result2 = tracker.assessHealth("Walking Steps", "5000 steps");
        assert result2.equals("Moderate activity. Keep it up!") : "Test Case 2 Failed";

        // Test Case 3: Assess Walking Steps (High Activity)
        String result3 = tracker.assessHealth("Walking Steps", "10000 steps");
        assert result3.equals("Excellent activity level!") : "Test Case 3 Failed";

        // Test Case 4: Assess Water Intake (Low Intake)
        String result4 = tracker.assessHealth("Water Intake (ml)", "1-2 glasses");
        assert result4.equals("Increase water intake.") : "Test Case 4 Failed";

        // Test Case 5: Assess Water Intake (Adequate Intake)
        String result5 = tracker.assessHealth("Water Intake (ml)", "7-12 glasses");
        assert result5.equals("Adequate hydration.") : "Test Case 5 Failed";

        // Test Case 6: Assess Water Intake (High Intake)
        String result6 = tracker.assessHealth("Water Intake (ml)", "15+ glasses");
        assert result6.equals("Excess water intake.") : "Test Case 6 Failed";

        // Test Case 7: Assess Heart Rate (Normal)
        String result7 = tracker.assessHealth("Heart Rate", "72 bpm");
        assert result7.equals("Heart rate is normal.") : "Test Case 7 Failed";

        // Test Case 8: Assess Heart Rate (Low)
        String result8 = tracker.assessHealth("Heart Rate", "50 bpm");
        assert result8.equals("Heart rate is low.") : "Test Case 8 Failed";

        // Test Case 9: Assess Heart Rate (High)
        String result9 = tracker.assessHealth("Heart Rate", "110 bpm");
        assert result9.equals("Heart rate is high.") : "Test Case 9 Failed";

        // Test Case 10: Empty Input for Parameters
        String result10 = tracker.assessHealth("", "");
        assert result10.equals("") : "Test Case 10 Failed";

        // Test Case 11: Unsupported Parameter
        String result11 = tracker.assessHealth("Unsupported Parameter", "Some Value");
        assert result11.equals("") : "Test Case 11 Failed";

        // Test Case 12: Null Parameter
        try {
            String result12 = tracker.assessHealth(null, "Some Value");
            assert result12.equals("") : "Test Case 12 Failed";
        } catch (Exception e) {
            assert false : "Test Case 12 Failed - Exception thrown for null parameter";
        }

        // Test Case 13: Null Value
        try {
            String result13 = tracker.assessHealth("Walking Steps", null);
            assert result13.equals("") : "Test Case 13 Failed";
        } catch (Exception e) {
            assert false : "Test Case 13 Failed - Exception thrown for null value";
        }

        // Test Case 14: Both Null Parameter and Value
        try {
            String result14 = tracker.assessHealth(null, null);
            assert result14.equals("") : "Test Case 14 Failed";
        } catch (Exception e) {
            assert false : "Test Case 14 Failed - Exception thrown for both null inputs";
        }

        // Test Case 15: Invalid Range for Walking Steps
        String result15 = tracker.assessHealth("Walking Steps", "-500 steps");
        assert result15.equals("Invalid range.") : "Test Case 15 Failed";

        // Test Case 16: Invalid Parameter
        String result16 = tracker.assessHealth("Random Parameter", "Some Value");
        assert result16.equals("") : "Test Case 16 Failed";

        // Test Case 17: Valid Parameter with Unexpected Value
        String result17 = tracker.assessHealth("Walking Steps", "unusual input");
        assert result17.equals("Invalid input.") : "Test Case 17 Failed";

        System.out.println("All test cases passed!");
    }
}
