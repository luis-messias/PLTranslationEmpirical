import java.util.Scanner;

public class codeforces_31_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read y (first input)
        if (!scanner.hasNextInt()) {
            System.out.println(-1);
            return;
        }
        int y = scanner.nextInt();

        // Read the array elements (second input line)
        if (!scanner.hasNextLine()) {
            System.out.println(-1);
            return;
        }
        String line = scanner.nextLine();
        String[] parts = line.trim().split("\\s+");

        if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
            System.out.println(-1);
            return;
        }

        int[] arr = new int[parts.length];
        try {
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException e) {
            // Handle case where input parts are not valid integers
            System.out.println(-1);
            return;
        }

        int n = arr.length;

        // Iterate through all distinct triplets (i, j, k)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    // Check the condition: arr[k] = arr[i] + arr[j] AND k, i, j are distinct
                    // The original Python code had extra checks: arr[k] != arr[j] and arr[k] != arr[i]
                    // We implement the core mathematical check and the distinct index check.
                    
                    if (k == i || k == j) {
                        continue;
                    }
                    
                    // Check if arr[k] equals the sum of arr[i] and arr[j]
                    if (arr[k] == arr[i] + arr[j]) {
                        // Found a triplet. Print 1-based indices and exit.
                        System.out.println(k + 1 + " " + j + 1 + " " + i + 1);
                        // Using System.exit(0) is generally discouraged in Java main methods, 
                        // but to mimic the Python 'exit()' behavior, we break out of all loops.
                        System.exit(0);
                    }
                }
            }
