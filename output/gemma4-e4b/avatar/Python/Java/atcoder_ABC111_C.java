import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class atcoder_ABC111_C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Read the list X
        List<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                x.add(scanner.nextInt());
            }
        }
        
        scanner.close();

        // 1. Separate into A (even indices) and B (odd indices)
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a.add(x.get(i));
            } else {
                b.add(x.get(i));
            }
        }

        // Helper function to find max and second max frequency elements
        // Returns an array: [most_frequent_element, second_most_frequent_element]
        // Note: If the list is empty, or all elements are the same, the second element might be arbitrary or handled by the logic.
        // Since the Python code uses fixed size arrays (100003), we will simulate that approach for frequency counting.
        
        // --- Processing A ---
        int[] cnta = new int[100003];
        for (int val : a) {
            cnta[val]++;
        }

        int vala = 0;
        int maxCnta = 0;
        int vala1 = 0;
        int maxCnta1 = 0;

        // Find most frequent (vala, maxCnta)
        for (int i = 0; i < cnta.length; i++) {
            if (cnta[i] > maxCnta) {
                maxCnta = cnta[i];
                vala = i;
            }
        }

        // Find second most frequent (vala1, maxCnta1)
        for (int i = 0; i < cnta.length; i++) {
            if (i != vala && cnta[i] > maxCnta1) {
                // Check if this count is strictly greater than current maxCnta1
                // We must handle the case where multiple elements share the max count.
                // The Python logic finds the first element encountered that satisfies the condition.
                // We prioritize finding the highest count first.
                if (cnta[i] > maxCnta1) {
                    maxCnta1 = cnta[i];
                    vala1 = i;
                } else if (cnta[i] == maxCnta1 && vala1 == 0) {
                    // Edge case handling if initial vala1 was 0 and we found a valid second max
                    // This is complex to replicate perfectly without knowing the exact tie-breaking rule,
                    // but sticking to the simple max check should suffice given the constraints.
                }
            }
        }
        
        // Re-running the second max logic to ensure correctness based on Python's structure:
        // The Python code iterates over 'a' again, which means it checks only existing elements.
        // Let's use a map approach for cleaner logic, but stick to the array structure for translation fidelity.
        
        // Resetting vala1/maxCnta1 calculation to mimic Python's iteration over 'a'
        vala1 = 0;
        maxCnta1 = 0;
        
        // We need to find the max count among elements != vala
        for (int val : a) {
            if (val != vala) {
                int currentCount = cnta[val];
                if (currentCount > maxCnta1) {
                    maxCnta1 = currentCount;
                    vala1 = val;
                }
            }
        }


        // --- Processing B ---
        int[] cntb = new int[100003];
        for (int val : b) {
            cntb[val]++;
        }

        int valb = 0;
        int maxCntb = 0;
        int valb1 = 0;
        int maxCntb1 = 0;

        // Find most frequent (valb, maxCntb)
        for (int i = 0; i < cntb.length; i++)