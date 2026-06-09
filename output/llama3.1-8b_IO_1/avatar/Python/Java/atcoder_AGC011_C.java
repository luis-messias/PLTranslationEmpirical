import java.util.*;

public class atcoder_AGC011_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean[] vis = new boolean[n + 1];
        int ci = 0;
        int cb = 0;
        int cc = 0;

        List<Integer>[] g = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        dfs(0, vis, g);

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            g[u].add(v);
            g[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (g[i].isEmpty()) {
                    ci++;
                } else {
                    if (dfs(i, vis, g)) {
                        cb++;
                    } else {
                        cc++;
                    }
                }
            }
        }

        System.out.println(ci * ci + 2 * ci * (n - ci) + cc * cc + 2 * cb * cc + 2 * cb * cb);
    }

    public static boolean dfs(int x, boolean[] vis, List<Integer>[] g) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, 1});
        boolean flag = true;

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();
            int u = pair[0];
            int col = pair[1];

            if (vis[u]) {
                flag &= vis[u] == col;
                continue;
            }

            vis[u] = col % 2; // Change here
            for (int v : g[u]) {
                stack.push(new int[]{v, 3 - col});
            }
        }

        return flag;
    }
}
