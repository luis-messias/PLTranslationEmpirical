import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atcoder_ABC118_C {

    // Function to calculate the Greatest Common Divisor (GCD) using Euclidean algorithm
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N (The first integer input, which is unused in the GCD calculation)
        if (!scanner.hasNextInt()) {
            return;
        }
        scanner.nextInt(); 

        // Read all subsequent integers into a list A
        List<Long> A = new ArrayList<>();
        while (scanner.hasNextInt()) {
            A.add(scanner.nextLong());
        }
        
        scanner.close();

        // Calculate the GCD of all elements in A (Reduction)
        if (A.isEmpty()) {
            // If the list is empty, we assume no output or handle based on specific requirements.
            // For this translation, we assume valid input leading to a GCD calculation.
            return;
        }

        long result = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            result = gcd(result, A.get(i));
        }

        // Print the final GCD
        System.out.println(result);
    }
}