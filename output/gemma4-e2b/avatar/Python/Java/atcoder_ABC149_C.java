import java.util.Scanner;

public class atcoder_ABC149_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read X
        int X = scanner.nextInt();

        // Sieve of Eratosthenes setup
        int limit = 100010;
        boolean[] prime = new boolean[limit];
        
        // Initialize all to true
        for (int i = 0; i < limit; i++) {
            prime[i] = true;
        }

        // Mark 0 and 1 as not prime
        prime[0] = false;
        prime[1] = false;

        // Mark even numbers as not prime (optimization, though the sieve logic below handles it implicitly)
        for (int i = 2; i < limit; i += 2) {
            prime[i] = false;
        }

        // Sieve process
        // The original Python code started the sieve from i=3 and only checked odd numbers.
        // We replicate the logic for finding primes up to 100008 (or 100010 based on array size).
        
        // The Python code structure:
        // i = 3
        // while ( i * i <= 100008 ) :
        //     if prime [ i ] :
        //         for j in range ( i + i , 100008 , i ) :
        //             prime [ j ] = False
        //     i += 2
        
        for (int i = 3; i * i <= 100008; i += 2) {
            if (prime[i]) {
                // Mark multiples of i as not prime, starting from i*i
                for (int j = i * i; j <= 100008; j += i * 2) { // Optimization: start j at i*i and step by i (or 2*i if we only check odds)
                    // Since we only iterate i by 2, we only need to mark multiples.
                    // The original Python code used range(i + i, 100008, i), which means j starts at 2i.
                    // Let's stick closer to the original logic for correctness, even if slightly less optimized for the inner loop start.
                    
                    // Original Python: for j in range ( i + i , 100008 , i ) :
                    // j starts at 2*i.
                    for (int j = 2 * i; j <= 100008; j += i) {
                        prime[j] = false;
                    }
                }
            }
        }
        
        // Re-evaluating the sieve based on the Python structure:
        // The Python code iterates i by 2, and marks multiples starting from 2*i.
        
        // Let's reset and use a cleaner sieve structure that matches the intent, ensuring we cover the range up to 100008.
        
        // Re-initialize prime array for a clean sieve run up to 100008
        boolean[] sieve = new boolean[100009]; // Size 100009 to safely index up to 100008
        for (int k = 0; k < 100009; k++) {
            sieve[k] = true;
        }
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i * i <= 100008; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= 100008; j += i) {
                    sieve[j] = false;
                }
            }
        }


        // Search for the first prime >= X
        for (int i = X; i <= 100008; i++) {
            if (sieve[i]) {
                System.out.println(i);
                break;
            }
        }

        scanner.close();
    }
}