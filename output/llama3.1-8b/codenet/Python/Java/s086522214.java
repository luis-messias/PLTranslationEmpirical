import java.util.*;
import java.io.*;

public class s086522214 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] T = S.split("/");
        int date = Integer.parseInt(T[1] + T[2]);
        if (date <= 430) {
            System.out.println("Heisei");
        } else {
            System.out.println("TBD");
        }
    }

    public static List<Integer> primeDecomposition(int n) {
        List<Integer> table = new ArrayList<>();
        int i = 2;
        while (i * i <= n) {
            while (n % i == 0) {
                n /= i;
                table.add(i);
            }
            i++;
        }
        if (n > 1) {
            table.add(n);
        }
        return table;
    }

    public static List<Integer> digit(int i) {
        List<Integer> list = new ArrayList<>();
        while (i > 0) {
            list.add(i % 10);
            i /= 10;
        }
        Collections.reverse(list);
        return list;
    }

    public static int getNearestValueIndex(List<Integer> list, int num) {
        int idx = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (Math.abs(list.get(i) - num) < Math.abs(list.get(idx) - num)) {
                idx = i;
            }
        }
        return idx;
    }

    public static void main2(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] x = new int[N];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(input[i]);
        }
        int[][] P = new int[N][2];
        String[] input2 = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            P[i][0] = Integer.parseInt(input2[0]);
            P[i][1] = Integer.parseInt(input2[1]);
        }
    }

    public static void main3(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int K = Integer.parseInt(sc.nextLine());
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else {
                for (int k = 1; k <= K; k++) {
                    if (N - k >= 0) {
                        dp[N - k] = Math.min(dp[N - k], dp[N - k - k] + Math.abs(h[N - k] - h[N - k - k]));
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static int getBit(int x, int i) {
        return (x >> i) & 1;
    }
}