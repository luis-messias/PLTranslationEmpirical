import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC142_C {

    public static void main(String[] args) {
        // The provided data is a sequence of numbers, likely representing records or values.
        // We will treat it as a single list of integers for processing.
        String dataString = "123 456 789 101 202 303 404 505 606 707 808 909 111 222 333 444 555 666 777 888 999 100 200 300 400 500 600 700 800 900 110 220 330 440 550 660 770 880 990 120 220 330 440 550 660 770 880 990 1000 2000 3000 4000 5000 6000 7000 8000 9000 1100 2200 3300 4400 5500 6600 7700 8800 9900 10000 20000 30000 40000 50000 60000 70000 80000 90000 11000 22000 33000 44000 55000 66000 77000 88000 99000 100000 200000 300000 400000 500000 600000 700000 800000 900000 110000 220000 330000 440000 550000 660000 770000 880000 990000 1000000 2000000 3000000 4000000 5000000 6000000 7000000 8000000 9000000 1100000 2200000 3300000 4400000 5500000 6600000 7700000 8800000 9900000 10000000 20000000 30000000 40000000 50000000 60000000 70000000 80000000 90000000 110000000 220000000 330000000 440000000 550000000 660000000 770000000 880000000 990000000 1000000000";

        // Split the string by whitespace and convert to a list of integers
        List<Integer> dataList = new ArrayList<>();
        String[] tokens = dataString.trim().split("\\s+");
        for (String token : tokens) {
            try {
                dataList.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                System.err.println("Skipping non-integer token: " + token);
            }
        }

        System.out.println("--- Data Processing Report ---");
        System.out.println("Total number of data points read: " + dataList.size());

        // --- Analysis 1: Basic Statistics ---
        if (!dataList.isEmpty()) {
            int sum = 0;
            int min = dataList.get(0);
            int max = dataList.get(0);

            for (int value : dataList) {
                sum += value;
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
            }

            double average = (double) sum / dataList.size();

            System.out.println("\n[Statistics]");
            System.out.println("Sum of all elements: " + sum);
            System.out.println("Average value: " + String.format("%.2f", average));
            System.out.println("Minimum value: " + min);
            System.out.println("Maximum value: " + max);
        } else {
            System.out.println("\n[Statistics] No data available for analysis.");
        }

        // --- Analysis 2: Frequency Count (Simple Example) ---
        // Count how many times each number appears (using a basic map simulation)
        java.util.Map<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int value : dataList) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }

        System.out.println("\n[Frequency Analysis (Top 5)]");
        // Sort and print the top 5 most frequent elements for brevity
        frequencyMap.entrySet().stream()
                .sorted(java.util.Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println("Value " + entry.getKey() + " appears " + entry.getValue() + " time(s)"));


        // --- Analysis 3: Identifying Patterns (Example: Checking for multiples of 11) ---
        System.out.println("\n[Pattern Detection]");
        long countMultiplesOf11 = dataList.stream()
                .filter(n -> n % 11 == 0)
                .count();

        System.out.println("Number of elements divisible by 11: " + countMultiplesOf11);

        // --- Analysis 4: Processing the last few elements (Demonstration) ---
        int countToProcess = Math.min(5, dataList.size());
        System.out.println("\n[Last " + countToProcess + " Elements]");
        for (int i = dataList.size() - countToProcess; i < dataList.size(); i++) {
            System.out.println("Element " + (i + 1) + ": " + dataList.get(i));
        }
    }
}
