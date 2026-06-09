import java.util.Scanner;

public class atcoder_AGC007_C {

    /**
     * Calculates the result based on the logic derived from the Python code.
     * N is treated as an integer counter, while d, x, and ret are doubles.
     */
    public static double main(int N_start, double d, double x) {
        double ret = 0;
        int N = N_start;

        while (N > 0) {
            // ret += d + ( N - 0.5 ) * x
            // N must be cast to double for the subtraction and multiplication.
            ret += d + ((double)N - 0.5) * x;

            // d = d + ( d / N ) + ( 5 * x ) / ( 2 * N )
            // N must be cast to double for division.
            d = d + (d / (double)N) + (5 * x) / (2 * (double)N);

            // x += 2 * x / N
            x += 2 * x / (double)N;

            // N -= 1
            N -= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N, d, x. N is read as an integer (int), d and x are treated as doubles.
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            double d = scanner.nextDouble();
            double x = scanner.nextDouble();
            
            double result = main(N, d, x);
            System.out.println(result);
        }
        scanner.close();
    }
}
