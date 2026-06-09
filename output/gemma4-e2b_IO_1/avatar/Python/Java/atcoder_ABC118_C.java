import java.util.Scanner;

public class atcoder_ABC118_C {

    // Helper function to calculate GCD using the Euclidean algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read N (first input)
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int N = scanner.nextInt();

        // 2. Read the list A (second input line)
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Split the line by whitespace to get the numbers
            String[] parts = line.trim().split("\\s+");

            if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
                scanner.close();
                return;
            }

            // Calculate the GCD of all elements in A (mimicking functools.reduce(fractions.gcd, A))
            int result = Integer.MAX_VALUE;
            boolean first = true;

            for (String part : parts) {
                try {
                    int current = Integer.parseInt(part);
                    if (first) {
                        result = current;
                        first = false;
                    } else {
                        result = gcd(result, current);
                    }
