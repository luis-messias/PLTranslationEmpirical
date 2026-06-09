import java.util.Scanner;
import java.lang.Math;

public class atcoder_ABC162_D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N (integer)
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int N = scanner.nextInt();
        
        // Read S (string)
        String S = scanner.next();
        scanner.close();

        // 1. Count R, G, B
        int rNum = 0;
        int gNum = 0;
        int bNum = 0;
        for (char c : S.toCharArray()) {
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
        int maxStep = (int) Math.ceil((double) N / 2.0);

        // Outer loop for step
        for (int step = 1; step <= maxStep; step++) {
            // Inner loop for starting index i
            // The loop runs while i + 2 * step < N, or i <= N - 2 * step - 1
            for (int
