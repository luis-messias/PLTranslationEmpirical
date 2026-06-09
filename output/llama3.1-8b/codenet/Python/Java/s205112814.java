import java.util.Scanner;

public class s205112814 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] gateCond = new int[m][2];
        for (int i = 0; i < m; i++) {
            gateCond[i][0] = scanner.nextInt();
            gateCond[i][1] = scanner.nextInt();
        }

        int maxUnderTh = Integer.MIN_VALUE;
        int minUpperTh = Integer.MAX_VALUE;
        for (int[] cond : gateCond) {
            if (cond[0] > maxUnderTh) {
                maxUnderTh = cond[0];
            }
            if (cond[1] < minUpperTh) {
                minUpperTh = cond[1];
            }
        }

        int result;
        if (minUpperTh - maxUnderTh >= 0) {
            result = minUpperTh - maxUnderTh + 1;
        } else {
            result = 0;
        }
        System.out.println(result);
    }
}