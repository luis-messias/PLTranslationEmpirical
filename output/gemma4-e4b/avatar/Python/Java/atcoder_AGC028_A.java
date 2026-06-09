import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class atcoder_AGC028_A {

    // Function to calculate GCD
    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and M
        if (!scanner.hasNextInt()) {
            // Handle case where N and M might not be provided correctly
            return;
        }
        long N = scanner.nextLong();
        long M = scanner.nextLong();

        // Read S and T
        String S = scanner.next();
        String T = scanner.next();

        // 1. Calculate Number_iMN
        List<Double> numberIMN = new ArrayList<>();
        for (long i = 0; i < N; i++) {
            // Python: i * M / N (float division)
            double val = (double) i * M / N;
            numberIMN.add(val);
        }

        // 2. Calculate Number_j (Set of j)
        Set<Double> numberJSet = new HashSet<>();
        for (long j = 0; j < M; j++) {
            numberJSet.add((double) j);
        }

        // 3. Find Kaburi_j (Intersection of Number_iMN and Number_j)
        Set<Double> kaburiJSet = new HashSet<>();
        for (double val : numberIMN) {
            // Check if val is present in numberJSet (within floating point tolerance, 
            // but since inputs are derived from integers, direct comparison should work 
            // if the calculation maintains precision, or we rely on the fact that 
            // the intersection elements must be integers).
            
            // Since the intersection elements must be integers (from Number_j), 
            // we check if the value is close to an integer and if that integer is in Number_j.
            long roundedVal = Math.round(val);
            if (Math.abs(val - roundedVal) < 1e-9 && roundedVal >= 0 && roundedVal < M) {
                kaburiJSet.add(val);
            }
        }

        // 4. Convert kaburiJSet to a list (maintaining order is not strictly required by Python logic, 
        // but we need a list structure for indexing)
        List<Double> kaburiJList = new ArrayList<>(kaburiJSet);
        
        // 5. Calculate Kaburi_i
        List<Long> kaburiIList