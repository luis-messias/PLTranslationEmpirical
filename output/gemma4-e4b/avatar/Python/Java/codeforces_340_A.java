import java.util.Scanner;

public class codeforces_340_A {

    // Calculates the Greatest Common Divisor (GCD) using Euclidean algorithm
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Calculates the Least Common Multiple (LCM)
    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        // Use the formula: lcm(a, b) = (|a * b|) / gcd(a, b)
        // To prevent potential overflow of a * b, we calculate (a / gcd(a, b)) * b
        return Math.abs(a / gcd(a, b)) * Math.abs(b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the four space-separated long integers
        if (!scanner.hasNextLong()) {
            return;
        }
        
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        
        scanner.close();

        // Calculate LCM(x, y)
        long lcm_val = lcm(x, y);

        // Calculate the count of multiples of lcm_val in the range [a, b]
        // Count = floor(b / lcm) - floor((a - 1) / lcm)
        
        // Since all variables are long, standard integer division handles the floor operation.
        long count = (b / lcm_val) - ((a - 1) / lcm_val);

        System.out.println(count);
    }
}