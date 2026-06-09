import java.util.Arrays;
import java.util.Scanner;

public class s896397037 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        char[] chars = input.toCharArray();

        // The original Python code assumes the input length is at least 4.
        // We replicate the logic directly, assuming sufficient length.
        if (chars.length >= 4) {
            Arrays.sort(chars);

            // Check the condition: s[0] == s[1] and s[0] != s[2] and s[2] == s[3]
            if (chars[0] == chars[1] && chars[0] != chars[2] && chars[2] == chars[3]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            // If the input is too short, the condition cannot be met based on the indices used.
            System.out.println("No");
        }
    }
}