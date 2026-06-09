import java.util.Scanner;

public class s752993784 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        // countRemainder[r] stores the count of substrings with remainder r.
        int[] countRemainder = new int[2019];
        
        // m represents 10^i mod 2019
        long m = 1; 
        int mod = 0; // current remainder
        
        int n = s.length();

        // Loop calculates remainders of suffixes
        for (int i = 0; i < n; i++) {
            // Character index: n - 1 - i
            // Digit value:
