import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class atcoder_ABC150_E {
    public static void main(String[] args) {
        long mod = 1_000_000_007L;
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextLong()) return;
        long n = scanner.nextLong();

        // Read the list c
        // Read the rest of the line or the next line containing c elements
        // Assuming the next input line contains the space-separated integers for c
        
        // Read the entire line for c and parse it
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        
        // Convert parts to long array
        long[] c = new long[n];
        for (int i = 0; i < n; i++) {
            c[i] = Long.parseLong(parts[i]);
        }

        // Sort c in reverse order (descending)
        Arrays.sort(c);
        // Reverse the sorted array
        for (int i = 0; i < n / 2; i++) {
            long temp = c[i];
            c[i] = c[n - 1 - i];
            c[n - 1 - i] = temp;
        }


        // Calculate b = 2^(2n - 2) mod mod
        // Modular exponentiation function (pow(base, exp, mod))
        long b = power(2, 2 * n - 2, mod);

        // Calculate a = 2 * b mod mod
        long a = (2 * b) % mod;

        // Calculate the final answer
        long ans = 0;
        for (int i = 0; i < n; i++) {
            // ans += c[i] * (a + i * b)
            long term = (a + (i * b) % mod) % mod;
            term = (term * (c[i] % mod)) % mod;
            ans = (ans + term) % mod;
        }

        System.out.println(ans);
        
        scanner.close();
    }

    // Modular exponentiation function: (base^exp) % mod
    public static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}