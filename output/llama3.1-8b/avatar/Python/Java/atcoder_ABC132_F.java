import java.util.Scanner;

public class atcoder_ABC132_F {
    static final int MOD = 10_000_000_007;
    static int n, k;
    static int[] coef;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        coef = new int[(int) Math.sqrt(n) + 1];
        for (int i = 1; i <= Math.sqrt(n); i++) {
            coef[i - 1] = (n / i) - (n / (i + 1));
        }
        int sumCoef = 0;
        for (int i : coef) {
            sumCoef += i;
        }
        for (int i = 0; i < n - sumCoef; i++) {
            coef[(int) Math.sqrt(n)]++;
        }

        reverse(coef);

        int[][] dp = new int[k + 1][coef.length];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            int tmp = 0;
            for (int j = coef.length - 1; j >= 0; j--) {
                tmp += dp[i - 1][(coef.length - 1) - j];
                if (tmp >= MOD) {
                    tmp -= MOD;
                }
                dp[i][(coef.length - 1) - j] = (int) ((long) coef[j] * tmp % MOD);
            }
        }

        int sumDp = 0;
        for (int i : dp[k]) {
            sumDp += i;
        }
        if (sumDp >= MOD) {
            sumDp -= MOD;
        }
        System.out.println(sumDp);
    }

    static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}