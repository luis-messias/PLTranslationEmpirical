import java.util.Scanner;
import java.util.Arrays;

public class s934308496 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and x
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        if (!scanner.hasNextInt()) return;
        int x = scanner.nextInt();

        // Read the array m
        int[] m = new int[n];
        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextInt()) return;
            m[i] = scanner.nextInt();
        }
        
        // Sort m
        Arrays.sort(m);
        
        // Calculate sum(m)
        long sumM = 0;
        for (int val : m) {
            sumM += val;
        }
        
        // Calculate result: n + (x - sum(m)) // m[0]
        // Use long for the result calculation to prevent potential overflow, although the inputs are read as int.
        long result = n + (x - sumM) / m[0];
        
        System.out.println(result);
        
        scanner.close();
    }
}