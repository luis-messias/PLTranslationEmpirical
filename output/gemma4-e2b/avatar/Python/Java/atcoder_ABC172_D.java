import java.util.Scanner;

public class atcoder_ABC172_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N from standard input, mimicking the behavior of the Python code reading input.
        if (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            long ans = 0;
            
            // Calculate the sum based on the formula:
            // ans += i * ( N // i ) * ( N // i + 1 ) // 2
            for (int i = 1; i <= N; i++) {
                // N // i is the floor division (integer division)
                long k = N / i;
                // Calculate i * k * (k + 1) / 2
                long term = (long)i * k * (k + 1) / 2;
                ans += term;
            }
            System