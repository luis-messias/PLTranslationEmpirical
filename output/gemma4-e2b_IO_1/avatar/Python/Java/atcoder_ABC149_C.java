import java.util.Scanner;

public class atcoder_ABC149_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read X
        int X = scanner.nextInt();

        // Sieve of Eratosthenes setup
        // The maximum index needed is 100008, so we use a size slightly larger.
        final int LIMIT = 100010;
        boolean[] isPrime = new boolean[LIMIT];
        
        // Initialize all to true
        for (int i = 0; i < LIMIT; i++) {
            isPrime[i] = true;
        }

        // Mark 0 and 1 as not prime
        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve process
        // We only need to check up to sqrt(LIMIT - 1) for the outer loop.
        for (int i = 2; i * i < LIMIT; i++) {
            if (isPrime[i]) {
                // Mark multiples of i as not prime, starting from i*i
                for (int j = i * i; j < LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Search for the first prime >= X
        for (int i = X; i < LIMIT; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                break;
            }
        }

        scanner.close();
    }
}
