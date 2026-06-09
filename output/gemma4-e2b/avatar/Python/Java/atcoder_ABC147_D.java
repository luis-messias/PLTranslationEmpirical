import java.util.Scanner;

public class atcoder_ABC147_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read the sequence for A (bits)
        // The Python code reads the rest of the line and splits it.
        // We read the next line of input for A.
        if (!scanner.hasNextLine()) {
            return;
        }
        String lineA = scanner.nextLine();
        String[] parts = lineA.split(" ");

        // Parse A into an array of integers (bits)
        int[] A = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            A[i] = Integer.parseInt(parts[i]);
        }

        long result = 0;
        long MOD = 1000000007;

        // The loop runs for b from 0 to 59
        for (int b = 0; b < 60; b++) {
            long bs = 0;
            // Calculate bs = sum of the b-th bit across all elements in A
            for (int i = 0; i < A.length; i++) {
                // Check the b-th bit of A[i]
                if (((A[i] >> b) & 1) == 1) {
                    bs++;
                }
            }

            // Calculate the term: bs * (N - bs) * (1 << b)
            // Use long for intermediate calculations to prevent overflow before modulo
            long term = (bs * (N - bs) * (1L << b));
            
            // Update result
            result = (result + term) % MOD;
        }

        System.out.println(result);
        scanner.close();
    }
}