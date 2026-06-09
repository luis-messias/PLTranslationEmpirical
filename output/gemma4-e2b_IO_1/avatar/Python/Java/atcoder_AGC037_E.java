import java.util.Scanner;
import java.lang.StringBuilder;

public class atcoder_AGC037_E {

    static int N, K;
    static String S;

    // Helper function to check if two substrings of length N are in a specific order
    // u: the main string
    // pointer1, pointer2: starting indices
    static boolean checkNormalDict(String u, int pointer1, int pointer2) {
        for (int i = 0; i < N; i++) {
            char char1 = u.charAt(pointer1 + i);
            char char2 = u.charAt(pointer2 + i);
            if (char1 > char2) {
                return true;
            } else if (char1 < char2) {
                return false;
            }
        }
        return false;
    }

    // Function to find the last dictionary (substring)
    static String getLastDict(String s_str) {
        // U = s_str + reverse(s_str)
        String reversed_s_str = new StringBuilder(s_str).reverse().toString();
        String U = s_str + reversed_s_str;
        
        // Find min character in s_str
        char minChar = s_str.charAt(0);
        for (int i = 1; i < s_str.length(); i++) {
            if (s_str.charAt(i) < minChar) {
                minChar = s_str.charAt(i);
            }
        }
        char c = minChar;

        int p = -1;
        // Find the first occurrence of c in U
        for (int i = 0; i < U.length(); i++) {
            if (U.charAt(i) == c) {
                p = i;
                break;
            }
        }

        if (p == -1) {
            return ""; 
        }
        
        int minindex = p;
        p += 1;

        // Iterate through subsequent occurrences of c
        while (p < U.length()) {
            if (U.charAt(p) == c) {
                if (checkNormalDict(U, minindex, p)) {
                    minindex = p;
                }
            }
            p += 1;
        }
        
        // Return U[minindex : minindex + N]
        return U.substring(minindex, minindex + N);
    }
