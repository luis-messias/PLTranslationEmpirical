import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC168_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read a, b, h, m from input
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int h = scanner.nextInt();
            int m = scanner.nextInt();

            // Calculate C based on the Python formula:
            // C = abs ( 360 / 60 * m - 360 / 12 * h - 360 / 12 / 60 * m )
            // Simplified: C = abs ( 6*m - 30*h - 0.5*m )
            // C = abs ( 5.5*m - 30*h )
            double C = Math.abs(360.0 / 60.0 * m - 360.0 / 12.0 * h - 360.0 / (12.0 / 60.0) * m);

            // The Python code uses floating point arithmetic throughout, so we use doubles.
            // Let's stick to the exact calculation structure for robustness, even if the simplified form is mathematically equivalent.
            
            double term1 = 360.0 / 60.0 * m;
            double term2 = 360.0 / 12.0 * h;
            double term3 = 360.0 / (12.0 / 60.0) * m; // 360 / 0.2 = 1800 * m, wait, 360 / (12/60) = 360 * 60 / 12 = 1800. Let's re-evaluate the Python expression: 360 / 12 / 60 * m = 0.5 * m.
            
            // Re-evaluating Python: 360 / 12 / 60 * m
            // 360 / 12 = 30
            // 30 / 60 = 0.5
            // 0.5 * m
            
            double C_calc = Math.abs(term1 - term2 - 0.5 * m);


            if (C_calc > 180) {
                C_calc = 360.0 - C_calc;
            }

            // cosC = math.cos ( math.radians ( C ) )
            double cosC = Math.cos(Math.toRadians(C_calc));

            // print ( math.sqrt ( a ** 2 + b ** 2 - 2 * a * b * cosC ) )
            double result = Math.sqrt(a * a + b * b - 2 * a * b * cosC);

            System.out.println(result);
        }
        
        scanner.close();
    }
}