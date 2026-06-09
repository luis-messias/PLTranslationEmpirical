import java.util.Scanner;
import java.lang.Math;

public class s205112814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read n and m
        if (!scanner.hasNextInt()) {
            // Handle case where input might be empty or malformed initially
            return;
        }
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Read gate_cond (m rows, 2 columns)
        int[][] gateCond = new int[m][2];
        for (int i = 0; i < m; i++) {
            gateCond[i][0] = scanner.nextInt();
            gateCond[i][1] = scanner.nextInt();
        }
        
        scanner.close();

        // Calculate max_under_th (max of the first column)
        int maxUnderTh = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            maxUnderTh = Math.max(maxUnderTh, gateCond[i][0]);
        }

        // Calculate min_upper_th (min of the second column)
        int minUpperTh = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minUpperTh = Math.min(minUpperTh, gateCond[i][1]);
        }

        // Calculate the result: max(0, min_upper_th - max_under_th + 1)
        int result = minUpperTh - maxUnderTh + 1;
        
        if (result < 0) {
            result = 0;
        }
        
        System.out.println(result);
    }
}
