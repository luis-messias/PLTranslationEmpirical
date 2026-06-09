import java.util.Scanner;

public class s486032847 {

    /**
     * Calculates the digital root of the number represented by string s.
     * This function recursively sums the digits until a single digit remains.
     * @param s The input number as a string.
     * @return The digital root (an integer).
     */
    public static int keta(String s) {
        if (s.length() < 2) {
            // Base case: convert string to integer
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                // Should not happen if input is valid digits
                return 0;
            }
        }

        // Calculate sum of digits
        int sum = 0;
        for (char c : s.toCharArray()) {
            // Convert character digit to its integer value
            sum += c - '0';
        }

        // Recursive call with the string representation of the sum
        return keta(String.valueOf(sum));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input N as a string
        String N = scanner.nextLine();
        scanner.close();

        int result = keta(N);

        if (result % 9 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}