import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class s534639230 {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] DStr = scanner.nextLine().split(" ");
        int[] D = new int[DStr.length];
        for (int i = 0; i < DStr.length; i++) {
            D[i] = Integer.parseInt(DStr[i]);
        }

        int mod = 998244353;

        if (D[0] != 0) {
            System.out.println(0);
            return;
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        for (int d : D) {
            cnt.put(d, cnt.getOrDefault(d, 0) + 1);
        }

        if (cnt.getOrDefault(0, 0) > 1) {
            System.out.println(0);
            return;
        }

        int res = 1;

        for (int i = 1; i <= max(D); i++) {
            if (cnt.get(i - 1) == 1) {
                continue;
            }
            res *= pow(cnt.get(i - 1), cnt.get(i), mod);
            res %= mod;
        }

        System.out.println(res);
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int pow(int a, int b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return (int) res;
    }
}