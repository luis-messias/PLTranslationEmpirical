import java.util.Scanner;
import java.lang.Math;

public class s031459110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read N
        int N = scanner.nextInt();
        
        // Read string c
        String c = scanner.next();
        
        // Calculate num_w (count of 'W')
        int num_w = 0;
        for (char ch : c.toCharArray()) {
            if (ch == 'W') {
                num_w++;
            }
        }
        
        // Calculate num_r (N - num_w)
        int num_r = N - num_w;
        
        // Construct the target string 'comp': R...R W...W
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num_r; i++) {
            sb.append('R');
        }
        for (int i = 0; i < num_w; i++) {
            sb.append('W');
        }
        String comp = sb.toString();
        
        // Calculate mismatches (ans) in the first num_r characters
        int ans = 0;
        for (int i = 0; i < num_r; i++) {
            // comp[i] is always 'R' for i < num_r
            if (c.charAt(i) != 'R') {
                ans++;
            }
        }
        
        // Calculate min(num_w, num_r, ans)
        int result = Math.min(num_w, Math.min(num_r, ans));
        
        System.out.println(result);
        
        scanner.close();
    }
}