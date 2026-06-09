import java.util.Scanner;

public class s922746568 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        
        int r_cnt = 0;
        int g_cnt = 0;
        int b_cnt = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                r_cnt++;
            } else if (c == 'G') {
                g_cnt++;
            } else if (c == 'B') {
                b_cnt++;
            }
        }
        
        int ans = r_cnt * g_cnt * b_cnt;
        
        for (int i = 0; i < n; i++) {
            for (int d = 0; d < n; d++) {
                int j = i + d;
                int k = j + d;
                if (k >= n) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j) && s.charAt(j) != s.charAt(k) && s.charAt(k) != s.charAt(i)) {
                    ans--;
                }
            }
        }
        
        System.out.println(ans);
    }
}
