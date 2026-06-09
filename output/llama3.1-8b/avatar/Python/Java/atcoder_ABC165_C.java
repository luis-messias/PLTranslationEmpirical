import java.util.*;

public class atcoder_ABC165_C {
    public static void solve(int N, int M, int Q, int[] a, int[] b, int[] c, int[] d) {
        int res = 0;
        dfs(N, new ArrayList<>(), res);
        System.out.println(res);
    }

    private static void dfs(int n, List<Integer> A, int res) {
        if (A.size() == n) {
            int ans = 0;
            for (int i = 0; i < Q; i++) {
                if (A.get(b[i] - 1) - A.get(a[i] - 1) == c[i]) {
                    ans += d[i];
                }
            }
            res = Math.max(res, ans);
            return;
        }

        int lastMax = A.isEmpty() ? 1 : A.get(A.size() - 1);
        for (int i = lastMax; i <= M; i++) {
            List<Integer> temp = new ArrayList<>(A);
            temp.add(i);
            dfs(n, temp, res);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Q = scanner.nextInt();

        a = new int[Q];
        b = new int[Q];
        c = new int[Q];
        d = new int[Q];

        for (int i = 0; i < Q; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
        }

        solve(N, M, Q, a, b, c, d);
    }

    static int[] a;
    static int[] b;
    static int[] c;
    static int[] d;
}