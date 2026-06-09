import java.util.Scanner;
import java.util.Arrays;

public class atcoder_ABC149_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read input X
        int X = scanner.nextInt();
        scanner.close();

        // The maximum number we need to check up to is 100008, 
        // so we use an array size of 100010 (indices 0 to 100009).
        final int ARRAY_SIZE = 100010;
        final int LIMIT = 100008;

        boolean[] prime = new boolean[ARRAY_SIZE];
        
        // Initialize all entries to true
        Arrays.fill(prime, true);
        
        // 0 and 1 are not prime
        prime[0] = false;
        prime[1] = false;

        // Mark all even numbers >= 4 as false
        for (int i = 4; i < ARRAY_SIZE; i += 2) {
            prime[i] = false;
        }

        // Sieve of Eratosthenes
        int i = 3;
        while (i * i <= LIMIT) {
            if (prime[i]) {
                // Mark multiples of i starting from 2*i
                for (int j = i + i; j <= LIMIT; j += i) {
                    prime[j] = false;
                }
            }
            i += 2;
        }

        // Find and print the first prime >= X
        for (int i = X; i <= LIMIT; i++) {
            if (prime[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}