import java.util.Scanner;
import java.lang.Math;

public class s636719275 {

    private static int check(String a, String b) {
        int s = 0;
        int length = a.length();
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                s++;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read s and t
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        
        int ans = 1000000; // 10**6
        
        int lenS = s.length();
        int lenT = t.length();
        
        // Iterate through all starting positions i such that a substring of length lenT can be formed.
        // i goes from 0 up to lenS - lenT.
        for (int i = 0; i <= lenS - lenT; i++) {
            // Get the substring of s starting at i, with length lenT.
            String current_s_prefix = s.substring(i, i + lenT);
            
            // Calculate the difference count between t and this prefix
            int current_diff = check(t, current_s_prefix);
            
            // Update minimum answer
            ans = Math.min(ans, current_diff);
        }
        
        System.out.println(ans);
        
        scanner.close();
    }
}