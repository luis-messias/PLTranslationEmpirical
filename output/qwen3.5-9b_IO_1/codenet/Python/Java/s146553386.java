import java.util.Scanner;

public class s146553386 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[2][n];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        
        // Reverse the second row
        for (int j = 0; j < n; j++) {
            a[1][j] = a[1][n - 1 - j];
        }
        
        // Compute cumulative sums
        int[] res_0 = new int[n];
        int[] res_1 = new int[n];
        
        int sum0 = 0;
        for (int i = 0; i < n; i++) {
            sum0 += a[0][i];
            res_0[i] = sum0;
        }
        
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += a[1][i];
            res_1[i] = sum1;
        }
        
        // Find maximum
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int check = res_0[i] + res_1[n - 1 - i];
            if (check > ans) {
                ans = check;
            }
        }
        
        System.out.println(ans);
    }
}
