import java.util.Scanner;

public class s200092246 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read N. Using long to prevent potential overflow issues with sums.
        long N = scanner.nextLong();
        scanner.close();

        // Variables to store the results corresponding to Python's ans array
        long A = -1; // ans[0] = i - 1
        long B = -1; // ans[1] = sum(1..i) - N

        long i = 1;
        long currentSum = 0;

        // Find the smallest i such that sum(1..i) >= N
        while (true) {
            currentSum += i;
            if (currentSum >= N) {
                A = i - 1;
                B = currentSum - N;
                break;
            }
            i++;
        }

        // Output loop: prints 1 to A, excluding B
        for (long j = 0; j <= A; j++) {
            long printValue = j + 1;
            if (printValue != B) {
                System.out.println(printValue);
            }
        }
    }
}