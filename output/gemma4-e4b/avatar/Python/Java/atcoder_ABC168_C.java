import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC168_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read a, b, h, m from standard input
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        
        scanner.close();
        
        // Calculate C: C = abs(360/60 * m - 360/12 * h - 360/12/60 * m)
        // Using double for floating point arithmetic
        double c = Math.abs(6.0 * m - 30.0 * h - 0.5 * m);
        
        // Angle adjustment
        if (c > 180) {
            c = 360.0 - c;
        }
        
        // Calculate cosC
        double cosC = Math.cos(Math.toRadians(c));
        
        // Calculate the final result using the Law of Cosines
        double result = Math.sqrt(a * a + b * b - 2 * a * b * cosC);
        
        System.out.println(result);
    }
}