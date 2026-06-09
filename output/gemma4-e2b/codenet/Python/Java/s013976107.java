import java.util.Scanner;

public class s013976107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read A and B from the first line
        String line1 = scanner.nextLine();
        String[] parts = line1.split(" ");
        int A = Integer.parseInt(parts[0]);
        // B is read but not used

        // Read S from the second line
        String S_str = scanner.nextLine();
        
        // Convert S to a character array
        char[] S = S_str.toCharArray();

        // Check the condition: S[A] == '-' AND S.count('-') == 1
        
        // Check bounds for S[A]
        if (A >= 0 && A < S.length) {
            if (S[A] == '-') {
                // Count the total number of '-' characters in S
                int hyphenCount = 0;
                for (char c : S) {
                    if (c == '-') {
                        hyphenCount++;
                    }
                }
                
                if (hyphenCount == 1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}