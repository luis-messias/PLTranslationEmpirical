import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s441329208 {

    // Helper function to sort the characters of a string and return the resulting string
    private static String sortString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Helper function to reverse a string
    private static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the first line
        String line1 = br.readLine();
        // Python's sorted(line1.rstrip())
        String s = sortString(line1 != null ? line1.trim() : "");

        // Read the second line
        String line2 = br.readLine();
        // 1. Sort the characters of line2
        String sortedLine2 = sortString(line2 != null ? line2.trim() : "");
        // 2. Reverse the sorted string
        String t = reverseString(sortedLine2);

        // Compare s and t lexicographically
        if (s.compareTo(t) < 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}