import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class codeforces_296_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Consume the rest of the line after n (if any)
        scanner.nextLine(); 

        // Read m (the line containing elements)
        if (!scanner.hasNextLine()) {
            return;
        }
        String lineM = scanner.nextLine();
        
        // Split m into an array of strings
        String[] mArray = lineM.split(" ");

        // Calculate frequencies of elements in m
        Map<String, Integer> counts = new HashMap<>();
        for (String s : mArray) {
            if (!s.isEmpty()) {
                counts.put(s, counts.getOrDefault(s, 0) + 1);
            }
        }

        boolean possible = true;
        
        // Check the condition for each unique element
        // The threshold is n / 2 + 1 (integer division)
        int threshold = n / 2 + 1;
        
        for (int count : counts.values()) {
            if (count >= threshold) {
                possible = false;
                break;
            }
        }

        // Print the result
        if (possible) {
