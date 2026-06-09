import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class codeforces_351_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        int n = scanner.nextInt();

        // Read the array of floats
        String line = scanner.nextLine();
        if (line.trim().isEmpty()) {
            // Handle case where the second line might be empty if n was the only input
            // Although typically the input format guarantees the line exists.
            // If we assume the input structure is strict, we might need to adjust how we read the line.
            // Since nextInt() consumes the first line, we need to read the next line for the array.
        }
        
        // Re-reading input robustly: If the input is provided line by line, 
        // we might need to consume the rest of the line after reading n.
        // A safer approach is to read all tokens if possible, but sticking to the Python logic:
        
        // Since nextInt() was called, the scanner cursor is right before the newline after n.
        // We need to consume the rest of the line containing n, and then read the next line for the array.
        scanner.nextLine(); // Consume the rest of the line after reading n
        
        String arrayLine = scanner.nextLine();
        String[] tokens = arrayLine.split("\\s+");
        
        List<Double> arrList = new ArrayList<>();
        for (String token : tokens) {
            if (!token.isEmpty()) {
                try {
                    arrList.add(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    // Ignore invalid tokens if any
                }
            }
        }
        
        // 1. Filter and calculate fractional parts
        List<Double> filteredArr = new ArrayList<>();
        for (double x : arrList) {
            double fractionalPart = x - Math.floor(x);
            // Check if the fractional part is non-zero (using a small epsilon for safety, 
            // but since the Python code uses direct comparison, we stick to it unless precision issues arise)
            if (Math.abs(fractionalPart) > 1e-9) { 
                filteredArr.add(fractionalPart);
            }
        }

        // 2. Sort the filtered list
        Collections.sort(filteredArr);

        // 3. Calculate o and arr_sum
        int lenArr = filteredArr.size();
        int o = 2 * n - lenArr;
        
        double arrSum = 0.0;
        for (double val : filteredArr) {
            arrSum += val;
        }

        // 4. Initialize res (using double for precision)
        double res = 2e9; 

        // 5. Loop and minimize
        for (int i = 0; i <= n; i++) {
            if (i + o >= n) {
                double currentDiff = Math.abs(i - arrSum);
                res = Math.min(res, currentDiff);
            }
        }

        // 6. Output formatted to three decimal places
        System.out.printf("%.3f%n", res);
        
        scanner.close();
    }
}