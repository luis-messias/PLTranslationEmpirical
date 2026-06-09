import java.util.Scanner;

public class atcoder_ABC174_E {
    public static boolean check(int[] lis, int k, int mid) {
        for (int i : lis) {
            if (i % mid == 0) {
                k += 1;
            }
            k -= (i / mid);
        }
        return k >= 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] lis = new int[n];
        input = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            lis[i] = Integer.parseInt(input[i]);
        }
        int a = 1, b = findMax(lis);
        int ans = b;
        while (a <= b) {
            int mid = (a + b) / 2;
            if (check(lis, k, mid)) {
                ans = mid;
                b = mid - 1;
            } else {
                a = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static int findMax(int[] lis) {
        int max = lis[0];
        for (int i : lis) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}