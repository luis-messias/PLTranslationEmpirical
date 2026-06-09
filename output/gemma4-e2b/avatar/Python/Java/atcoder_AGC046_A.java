import java.util.Scanner;

class Solution {
    // Function to calculate the Greatest Common Divisor (GCD) using the Euclidean algorithm
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the integer x from input
        if (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            
            // Calculate 360 / gcd(360, x)
            int result = 360 / gcd(360, x);
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}