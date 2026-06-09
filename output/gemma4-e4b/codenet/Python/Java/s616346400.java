import java.util.Scanner;

public class s616346400 {

    public static String atc_079a(String input_value) {
        int n = 3;
        int L = input_value.length();

        // Outer loop: i iterates through possible starting positions
        // We need i + n - 1 < L, so i <= L - n
        for (int i = 0; i <= L - n; i++) {
            // Inner loop: j checks relative positions (1, 2, ..., n-1)
            for (int j = 1; j < n; j++) {
                if (input_value.charAt(i) != input_value.charAt(i + j)) {
                    break; // Mismatch found, break inner loop and try next i
                }
                
                // If we successfully checked the last required position (j = n - 1)
                if (j == n - 1) {
                    return "Yes"; // Pattern found: s[i] == s[i+1] == s[i+2]
                }
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input_value = scanner.nextLine();
        System.out.println(atc_079a(input_value));
        scanner.close();
    }
}