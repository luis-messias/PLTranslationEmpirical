import java.util.Scanner;

public class s922746568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int n = scanner.nextInt();
        
        // Read S
        if (!scanner.hasNext()) {
            return;
        }
        String s = scanner.next();
        
        // Calculate initial counts
        long r_cnt = 0;
        long g_cnt = 0;
        long b_cnt = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                r_cnt++;
            } else if (c == 'G') {
                g_cnt++;
            } else if (c == 'B') {
                b_cnt++;
            }
        }
        
        // Calculate initial answer
        long ans = r_cnt * g_cnt * b_cnt;
        
        // Iterate through arithmetic progressions (i, i+d, i+2d)
        for (int i = 0; i < n; i++) {
            for (int d = 0; d < n; d++) {
                int j = i + d;
                int k = j + d;
                
                if (k >= n) {
                    break; 
                }
                
                char charI = s.charAt(i);
                char charJ = s.charAt(j);
                char charK = s.charAt(k);
                
                // Check if all three characters are different