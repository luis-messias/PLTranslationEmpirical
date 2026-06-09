import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC162_D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();

        // Read S
        if (!scanner.hasNext()) {
            return;
        }
        String S = scanner.next();

        // The Python code uses N and S in the calculate function.
        // We assume N is the length of S, or N is just an input parameter.
        // Based on the Python structure, N is the first input, S is the second.
        
        // We use N as the length of S for consistency with the loop bounds, 
        // although the Python code uses n (which is N) and s (which is S).
        int n = S.length();
        String s = S;

        int rNum = 0;
        int gNum = 0;
        int bNum = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                rNum++;
            } else if (c == 'G') {
                gNum++;
            } else if (c == 'B') {
                bNum++;
            }
        }

        int sum = 0;
        
        // Equivalent to math.ceil(n / 2) + 1
        int maxStep = (int) Math.ceil((double) n / 2.0) + 1;

        for (int step = 1; step <= maxStep; step++) {
            // Equivalent to range(n - 2 * step)
            for (int i = 0; i < n - 2 * step; i++) {
                // Construct the triplet: arr[i], arr[i + step], arr[i + 2*step]
                String triplet = "" + s.charAt(i) +