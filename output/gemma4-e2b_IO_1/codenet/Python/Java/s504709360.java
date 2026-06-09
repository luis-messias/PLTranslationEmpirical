import java.util.Scanner;

public class s504709360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        if (s.length() < 26) {
            // Case 1: Check if any lowercase letter from 'a' to 'z' is missing
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                if (s.indexOf(c) == -1) {
                    System.out.println(s + c);
                    return;
                }
            }
        } else {
            // Case 2: s.length() >= 26
            // Iterate i from 25 down to 1 (reversed(range(1, 26)))
            for (int i = 25; i >= 1; i--) {
                // Check s[i-1] < s[i]
                if (s.charAt(i - 1) < s.charAt(i)) {
                    // s1 = s[0:i-1]
                    String s1 = s.substring(0, i - 1);
                    
                    // Iterate j from 0 to 25
                    for (int j = 0; j < 26; j++) {
                        char c = (char) ('a' + j);
                        
                        // Check c > s[i-1] and c not in s1
                        if (c > s.charAt(i - 1) && !s1.contains(String.valueOf(c
