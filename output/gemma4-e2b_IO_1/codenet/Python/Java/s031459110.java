import java.util.Scanner;
import java.lang.Math;

public class s031459110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N
        if (!scanner.hasNextInt()) {
            return;
        }
        int N = scanner.nextInt();
        
        // Read C
        if (!scanner.hasNext()) {
            return;
        }
        String c = scanner.next();

        // Calculate num_w and num_r
        int num_w = 0;
        for (int i = 0; i < N; i++) {
            if (c.charAt(i) == 'W') {
                num_w++;
            }
        }
        int num_r = N - num_w;

        // Construct comp = "R"*num_r + "W"*num_w
        StringBuilder compBuilder = new StringBuilder();
        for (int i = 0; i < num_r; i++) {
            compBuilder.append('R');
        }
        for (int i = 0; i < num_w; i++) {
            compBuilder.append('W');
        }
        String comp = compBuilder.toString();

        // Compare the first num_r characters
        int ans = 0;
        for (int i = 0; i < num_r; i++) {
            if (c.charAt(i) != comp.charAt(i)) {
                ans++;
            }
        }

        // ans = min(num_w, num_r, ans)
        int result = Math.min(num_w, Math.min(num_r, ans));

        System.out.println(result);
        
        scanner.close();
    }
}
