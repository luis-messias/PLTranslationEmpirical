import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read initial n
        int n = scanner.nextInt();
        scanner.close();

        // Loop i from n down to 1
        for (int i = n; i >= 1; i--) {
            // Check divisibility using the current value of n
            if (n % i == 0) {
                // Update n
                n = i;
                // Print i followed by a space
                System.out.print(i + " ");
            }
        }
    }
}