import java.util.Scanner;
import java.lang.Math;

public class atcoder_AGC037_E {

    static long N;
    static long K;
    static String S;

    // Helper function to check if the substring starting at pointer1 is lexicographically greater than the substring starting at pointer2
    // Returns true if u[pointer1:pointer1+N] > u[pointer2:pointer2+N]
    static boolean check_normal_dict(String u, int pointer1, int pointer2) {
        for (int i = 0; i < N; i++) {
            char char1 = u.charAt(pointer1 + i);
            char char2 = u.charAt(pointer2 + i);
            if (char1 > char2) {
                return true;
            } else if (char1 < char2) {
                return false;
            }
        }
        // They are equal
        return false;
    }

    // Finds the last dictionary string
    static String get_last_dict(String s_str) {
        // U = s_str + s_str[::-1]
        String reversed_s = new StringBuilder(s_str).reverse().toString();
        String U = s_str + reversed_s;
        
        // c = min(s_str)
        char c = s_str.charAt(0);
        for (char ch : s_str.toCharArray()) {
            if (ch < c) {
                c = ch;
            }
        }

        // Find first occurrence of c in U
        int p = U.indexOf(c);
        
        int minindex = p;
        
        // p += 1; // Start checking from the next index
        p = p + 1;
        
        // The original Python loop condition was 'while p <= N'. We replicate this, 
        // although it might be logically incorrect for the full length of U.
        while (p <= N && p < U.length()) {
            if (U.charAt(p) == c) {
                // Check if the substring starting at p is lexicographically greater than the substring starting at minindex
                if (check_normal_dict(U, minindex, p)) {
                    minindex = p;
                }
            }
            p++;
        }
        
        // Return U[minindex : minindex + N]
        return U.substring(minindex, minindex + (int) N);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N and K
        if (!scanner.hasNextLong()) {
            scanner.close();
            return;
        }
        N = scanner.nextLong();
        K = scanner.nextLong();
        
        // Read S
        S = scanner.next();
        
        scanner.close();

        // Initial check (aaaa)
        boolean aaaa = false;
        if (K >= 15) {
            aaaa = true;
        } else {
            // Check 2^K >= N. Use Math.pow for safety, casting to long.
            if (Math.pow(
