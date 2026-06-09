import java.util.Scanner;

public class codeforces_58_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the integer n
        int n = scanner.nextInt();

        // Loop i from n down to 1
        for (int i = n; i >= 1; i--) {
            // Check if n is divisible by i
            if (n % i == 0) {
                // Update n and print i followed by a space
                n = i;
                System.out.print(i + " ");
            }
        }
    }
}