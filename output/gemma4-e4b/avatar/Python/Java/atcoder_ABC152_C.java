import java.util.Scanner;

public class atcoder_ABC152_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read the array n
        int[] n = new int[N];
        for (int i = 0; i < N; i++) {
            if (!scanner.hasNextInt()) {
                // Handle case where input ends prematurely
                return;
            }
            n[i] = scanner.nextInt();
        }

        // Initialize variables
        int a = 1;
        int pos = 0;

        // Loop from i = 1 up to N-1
        for (int i = 1; i < N; i++) {
            // Check if n[pos] > n[i]
            if (n[pos] > n[i]) {
                a += 1;
                pos = i;
            }
        }

        // Print the result
        System.out.println(a);
        
        scanner.close();
    }
}