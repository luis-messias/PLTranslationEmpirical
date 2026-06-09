import java.util.Scanner;
import java.util.Arrays;

public class s683277023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and k from the first line
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        if (!scanner.hasNextInt()) return;
        int k = scanner.nextInt();

        // Read the list of numbers from the second line
        // We read the rest of the line as the list elements
        // Since the input format implies reading the next line for the list:
        
        // Read the entire line for the list elements
        // Note: In competitive programming environments, reading input line by line is safer.
        // Assuming the list elements are on the next line:
        
        // Read the list elements
        int[] li = new int[n];
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                li[i] = scanner.nextInt();
            }
        }

        // Sort the list
        Arrays.sort(li);

        // Calculate the sum of the first k elements
        long sum = 0;
        for (int i = 0; i < k; i++) {
            if (i < li.length) {
                sum += li[i];
            }
        }

        System.out.println(sum);
        
        scanner.close();
    }
}