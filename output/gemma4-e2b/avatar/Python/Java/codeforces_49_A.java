import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class codeforces_49_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the input string
        String a = scanner.nextLine();

        // Define the set of vowels (vo)
        Set<Character> vo = new HashSet<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'
        ));

        // Iterate backward through the string
        for (int i = a.length() - 1; i >= 0; i--) {
            char currentChar = a.charAt(i);

            // Check if the character is a space or a question mark
            if (currentChar == ' ' || currentChar == '?') {
                continue;
            } else {
                // Check if the character is in the set of vowels
                if (vo.contains(currentChar)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                // Break the loop immediately after finding the first match/mismatch
                break;
            }
        }
        scanner.close();
    }
}