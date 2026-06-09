import java.util.Scanner;

public class s013976107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read A and B (First line)
        // We assume the input format is two integers followed by a newline, then the string S.
        if (!scanner.hasNextInt()) {
            // Handle case where input might be missing
            return;
        }
        
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        // Consume the rest of the line after reading B
        scanner.nextLine(); 

        // Read S (Second line)
        String S = scanner.nextLine();
        
        // Check 1: S[A] == '-'
        boolean condition1 = (S.charAt(A) == '-');
        
        // Check 2: S.count('-') == 1
        int hyphenCount = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                hyphenCount++;
            }
        }
        boolean condition2 = (hyphenCount == 1);
        
        // Output result
        if (condition1 && condition2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        scanner.close();
    }
}