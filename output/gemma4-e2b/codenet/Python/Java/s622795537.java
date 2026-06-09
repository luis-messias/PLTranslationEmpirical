import java.util.*;
import java.io.*;

public class s622795537 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading n

        Map<String, Integer> arr = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                arr.put(s, arr.getOrDefault(s, 0) + 1);
            }
        }

        if (arr.isEmpty()) {
            scanner.close();
            return;
        }

        // Find the maximum count
        int maxCount = 0;
        for (int count : arr.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        // Collect keys that have the maximum count
        List<String> dic = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : arr.entrySet()) {
            if (entry.getValue() == maxCount) {
                dic.add(entry.getKey());
            }
        }

        // Sort the list
        Collections.sort(dic);

        // Print the results
        for (String s : dic) {
            System.out.println(s);
        }

        scanner.close();
    }
}