import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class codeforces_608_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read N and S
        String line1 = br.readLine();
        if (line1 == null) return;
        StringTokenizer st1 = new StringTokenizer(line1);
        
        int n = Integer.parseInt(st1.nextToken());
        int s = Integer.parseInt(st1.nextToken());
        
        int c = 0;
        
        // Loop N times
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            
            // Read F and T
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            // Calculate X = t - (s - f)
            int x = t - (s - f);
            
            // Update C = max(C, X)
            if (x > c) {
                c = x;
            }
        }
        
        // Print S + C
        System.out.println(s + c);
    }
}