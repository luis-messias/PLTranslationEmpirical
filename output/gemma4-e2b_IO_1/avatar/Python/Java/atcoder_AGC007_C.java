import java.util.Scanner;

public class atcoder_AGC007_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N, d, x from standard input. Assuming they are provided space-separated.
        if (scanner.hasNextDouble()) {
            double N = scanner.nextDouble();
            double d = scanner.nextDouble();
            double x = scanner.nextDouble();

            double result = main(N, d, x);
            System.out.println(result);
        }

        scanner.close();
    }

    public static double main(double N, double d, double x) {
        double ret = 0;
        
        // The loop runs while N is positive, matching Python's `while N:`
        while (N > 0) {
            // ret += d + ( N - 0.5 ) * x
            ret += d + (N - 0.5) * x;
            
            // d = d + ( d / N ) + ( 5 * x ) / ( 2 * N )
            // Note: Java handles division of doubles correctly.
            d = d + (d / N) + (5 * x) / (2 * N);
            
            // x += 2 * x / N
            x += 2 * x / N;
            
            // N -= 1
            N -= 1;
        }
        return ret;
    }
}
