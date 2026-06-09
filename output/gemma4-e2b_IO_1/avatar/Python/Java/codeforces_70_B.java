import java.util.Scanner;

public class codeforces_70_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Read the input string
        if (!scanner.hasNextLine()) {
            return;
        }
        String input = scanner.nextLine();

        int ans = 1;
        int sumL = 0;

        // Equivalent to re.split("[.?!]", input)
        String[] parts = input.split("[.?!]");

        for (String s : parts) {
            // s = s.strip() + '.'
            String trimmedS = s.trim();
            String s_modified = trimmedS + ".";
            int L = s_modified.length();

            if (L > 1) {
                if (L > n) {
                    System.out.println("Impossible");
                    return;
                }
                
                // if sumL + L + (sumL > 0) > n:
                if (sumL + L + (sumL > 0) > n) {
                    ans += 1;
                    sumL
