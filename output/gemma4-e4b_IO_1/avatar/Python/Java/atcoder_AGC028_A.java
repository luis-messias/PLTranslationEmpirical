import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
        if (!scanner.hasNextLong()) {
            return;
        }
        long N = scanner.nextLong();
        long M = scanner.nextLong();

        // Read S and T
        String S = scanner.next();
        String T = scanner.next();

        // 1. Calculate Number_iMN (List of doubles: i * M / N)
        List<Double> numberIMN = new ArrayList<>();
        for (long i = 0; i < N; i++) {
            // Python: i * M / N (float division)
            double val = (double) i * M / N;
            numberIMN.add(val);
        }

        // 2. Calculate Number_j (Set of j: 0 to M-1)
        Set<Double> numberJSet = new HashSet<>();
        for (
