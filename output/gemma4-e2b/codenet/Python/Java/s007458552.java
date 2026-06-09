import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s007458552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read n (II())
        String lineN = br.readLine();
        if (lineN == null) return;
        int n = Integer.parseInt(lineN.trim());

        // Read S (SI())
        String S = br.readLine();
        if (S == null) return;

        // Calculate C = Counter(S) and check the condition C['R'] > n - C['R']
        int rCount = 0;
        for (char c : S.toCharArray()) {
            if (c == 'R') {
                rCount++;
            }
        }

        // Check if C['R'] > n - C['R']
        // C['R'] is rCount
        // n - C['R'] is the count of all other characters
        
        if (rCount > n - rCount) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}