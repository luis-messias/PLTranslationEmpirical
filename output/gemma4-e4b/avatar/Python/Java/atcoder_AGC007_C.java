import java.util.Scanner;

public class atcoder_AGC007_C {

    public static double main(double N, double d, double x) {
        double ret = 0;
        double currentN = N;

        while (currentN > 0) {
            // ret += d + ( N - 0.5 ) * x
            ret += d + (currentN - 0.5) * x;

            // d = d + ( d / N ) + ( 5 * x ) / ( 2 * N )
            d = d + (d / currentN) + (5 * x) / (2 * currentN);

            // x += 2 * x / N
            x += 2 * x / currentN;

            // N -= 1
            currentN -= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N, d, x. Since the calculations involve floating-point arithmetic, 
        // we read them as doubles.
        if (scanner.hasNextDouble()) {
            double N = scanner.nextDouble();
            double d = scanner.nextDouble();
            double x = scanner.nextDouble();
            
            double result = main(N, d, x);
            System.out.println(result);
        }
        scanner.close();
    }
}