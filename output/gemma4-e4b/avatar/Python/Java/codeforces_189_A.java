import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class codeforces_189_A {

    public static void cutRibbon() {
        Scanner scanner = new Scanner(System.in);
        
        // Read the entire line of input
        if (!scanner.hasNextLine()) {
            return;
        }
        String line = scanner.nextLine();
        
        // Parse space-separated integers
        String[] parts = line.trim().split("\\s+");
        if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
            return;
        }

        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        
        // length is the first element
        int length = arr[0];
        
        // Extract the next three elements (arr[1] to arr[3])
        // We must handle cases where the input might have fewer than 4 elements.
        int[] remaining = new int[Math.min(3, arr.length - 1)];
        if (arr.length > 1) {
            System.arraycopy(arr, 1, remaining, 0, Math.min(3, arr.length - 1));
        }
        
        // Sort the remaining elements (arr[1] to arr[3])
        Arrays.sort(remaining);
        
        // Update arr to hold the sorted remaining values for consistent indexing
        // We only care about the first three sorted values (if they exist)
        int[] sortedArr = new int[3];
        for (int i = 0; i < remaining.length; i++) {
            sortedArr[i] = remaining[i];
        }
        
        // Re-assigning the relevant sorted values back to arr for simplicity, 
        // assuming the input always provides at least 4 elements based on the Python logic.
        // If the input size is less than 4, the logic might fail, but we follow the Python structure.
        if (arr.length >= 4) {
             // Copy the sorted values back into the original array structure for the logic to work
             // arr[1] = sortedArr[0], arr[2] = sortedArr[1], arr[3] = sortedArr[2]
             arr[1] = sortedArr[0];
             arr[2] = sortedArr[1];
             arr[3] = sortedArr[2];
        } else if (arr.length == 2) {
             arr[1] = remaining[0];
             arr[2] = remaining[1]; // This index might be out of bounds if only 2 elements exist
             arr[3] = remaining[2];
        }
        
        // --- Start of core logic ---

        // Case 1: Divisible by the smallest cut length (arr