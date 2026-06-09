import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC162_D {

    public static void calculate(int n, String s) {
        // 1. Count R, G, B
        int rNum = 0;
        int gNum = 0;
        int bNum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                rNum++;
            } else if (c == 'G') {
                gNum++;
            } else if (c == 'B') {
                bNum++;
            }
        }

        int sum = 0;
        
        // Calculate max step: ceil(N / 2)
        // Using Math.ceil requires casting to double
        int maxStep = (int) Math.ceil((double) n / 2.0);

        // Outer loop for step
        for (int step = 1; step <= maxStep; step++) {
            // Inner loop for starting index i
            // The range limit is N - 2 * step. The loop runs while i <= N - 2 * step - 1
            for (int i = 0; i <= n - 2 * step - 1; i++) {
                
                // Get the three characters
                char c1 = s.charAt(i);
                char c2 = s.charAt(i + step);
                char c3 = s.charAt(i + 2 * step);

                // Check if the triplet {c1, c2, c3} is a permutation of {R, G, B}
                // This means all three characters must be distinct and must be R, G, B.
                
                boolean hasR = false;
                boolean hasG = false;
                boolean hasB = false;

                if (c1 == 'R') hasR = true;
                else if (c1 == 'G') hasG = true;
                else if (c1 == 'B') hasB = true;

                if (c2 == 'R') hasR = true;
                else if (c2 == 'G') hasG = true;
                else if (c2 == 'B') hasB = true;

                if (c3 == 'R') hasR = true;
                else if (c3 == 'G') hasG = true;
                else if (c3 == 'B') hasB = true;
                
                // Check if we found exactly one of each color
                if (hasR && hasG && hasB) {
                    // We must also ensure they are distinct, which is guaranteed if we only count R, G, B
                    // and we check for the presence of all three.
                    
                    // A more rigorous check for distinctness:
                    if (c1 != c2 && c1 != c3 && c2 != c3) {