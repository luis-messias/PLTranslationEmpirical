import java.util.Scanner;

public class atcoder_AGC046_A {

    // Helper function to calculate the Greatest Common Divisor (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the integer input x
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            
            // Calculate 360 / gcd(360, x)
            int commonDivisor = gcd(360, x);
            int result = 360 / commonDivisor;
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}