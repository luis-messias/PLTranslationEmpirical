import java.util.Scanner;
import java.util.regex.Pattern;

public class codeforces_70_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line after reading n

        // Read the sentence string
        String inputString = scanner.nextLine();
        
        // Split the string by delimiters: ., ?, !
        String[] segments = inputString.split("[.?!]");

        int ans = 1;
        int sumL = 0;

        for (String s : segments) {
            String cleanedS = s.trim();
            
            if (cleanedS.isEmpty()) {
                continue;
            }
            
            // Append the period as per Python logic: s = s.strip() + '.'
            String s_with_dot = cleanedS + ".";
            int L = s_with_dot.length();

            if (L > 1) {
                // Check if a single segment is too long
                if (L > n) {
                    System.out.println("Impossible");
                    return;
                }

                // Calculate the required length if we add this segment
                int requiredLength;
                if (sumL == 0) {
                    // First segment
