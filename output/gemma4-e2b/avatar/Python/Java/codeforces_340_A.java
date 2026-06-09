import java.util.Scanner;

public class codeforces_340_A {

    // Function to calculate GCD (G) using the Euclidean algorithm
    public static int G(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM (L)
    public static long L(int a, int b) {
        // LCM(a, b) = (|a * b|) / GCD(a, b)
        // Use long for intermediate product to prevent overflow, although for typical constraints, int might suffice.
        // Since the result is used in division, we calculate it as (a / G(a, b)) * b to be safer against overflow if a*b is huge.
        long gcd = G(a, b);
        return ((long) a / gcd) * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the four space-separated integers: x, y, a, b
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // Calculate LCM(x, y)
            long lcm = L(x, y);

            // Calculate the result: b // lcm - (a - 1) // lcm
            // Note: Since the Python code uses integer division (//), we maintain integer division here.
            long result = (long) b / lcm - (long) (a - 1) / lcm;

            System.out.println(result);
        }
        
        scanner.close();
    }
}