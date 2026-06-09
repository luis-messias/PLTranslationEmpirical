import java.util.Scanner;

public class atcoder_AGC007_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N, d, x from standard input
        if (scanner.hasNextDouble()) {
            double N = scanner.nextDouble();
            double d = scanner.nextDouble();
            double x = scanner.nextDouble();

            // Call the logic function
            double result = main(N, d, x);
            System.out.println(result);
        }

        scanner.close();
    }

    public static double main(double N, double d, double x) {
        double ret = 0;
        
        // The loop condition in Python is `while N:`, which means while N is non-zero.
        // Since N is decremented by 1 in each step, we iterate N times.
        while (N > 0) {
            // ret += d + ( N - 0.5 ) * x
            ret += d + (N - 0.5) * x;
            
            // d = d + ( d / N ) + ( 5 * x ) / ( 2 * N )
            d = d + (d / N) + (5 * x) / (2 * N);
            
            // x +=