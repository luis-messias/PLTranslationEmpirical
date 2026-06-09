import java.util.Scanner;
import java.util.Arrays;

public class s259116349 {

    // Global variables to store precalculated values
    private static int[][] divs = new int[101][];
    private static int[] divsum = new int[15];
    private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
    private static final int NUM_PRIMES = primes.length;

    /**
     * Calculates the prime factorization exponents for all numbers from 1 to 100.
     * divs[i][j] stores the exponent of primes[j] in the factorization of i.
     */
    private static void calculateDivs() {
        for (int i = 0; i < NUM_PRIMES; i++) {
            divs[i] = new int[NUM_PRIMES];
        }

        for (int i = 1; i <= 100; i++) {
            int temp_i = i;
            int[] tmp = new int[NUM_PRIMES];
            
            for (int j = 0; j < NUM_PRIMES; j++) {
                int p = primes[j];
                int count = 0;
                
                // Count how many times p divides temp_i
                while (temp_i > 0 && temp_i % p == 0) {
                    count++;
                    temp_i /= p;
                }
                tmp[j] = count;
            }
            divs[i] = tmp;
        }
    }

    /**
     * Calculates the sum of exponents for primes in N! (stored in divsum).
     * divsum[j] = sum(exponent of primes[j] in i for i=1 to N)
     */
    private static void calculateDivSum(int N) {
        Arrays.fill(divsum, 0);
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < NUM_PRIMES; j++) {
                divsum[j] += divs[i][j];
            }
        }
    }

    /**
     * Counts how many exponents in divsum are greater than or equal to n_minus_1.
     * Equivalent to Python's num(n).
     */
    private static long num(int n) {
        if (n <= 0) return 0;
        int threshold = n - 1;
        long count = 0;
        for (int exponent : divsum) {
            if (exponent >= threshold) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        // Step 1: Precalculate factorizations up to 100
        calculateDivs();

        // Step 2: Calculate the sum of exponents up to N
        calculateDivSum(N);

        // Step 3: Calculate the final answer based on the combinatorial logic
        long ans = 0;

        // >=74
        ans += num(75);

        // >=14 & 13~4
        ans += num(15) * (num(5) - 1);

        // >=24 & 23~2
        ans += num(25) * (num(3) - 1);

        // >=4,>=4 & >=2
        // Note: Integer division // in Python corresponds to standard integer arithmetic in Java
        ans += num(5) * (num(5) - 1) * (num(3) - 2) / 2; 
        
        System.out.println(ans);
    }
}
