import java.util.*;

public class codeforces_216_B {
    public static int[] readInts() {
        String[] input = scanner.nextLine().split(" ");
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }

    public static void dfs(Map<Integer, Set<Integer>> g, Set<Integer> seen, int i) {
        if (seen.contains(i)) {
            return;
        }
        seen.add(i);
        int nodes = 1;
        int edges = g.get(i).size();
        for (int j : g.get(i)) {
            int[] x = dfs(g, seen, j);
            nodes += x[0];
            edges += x[1];
        }
    }

    public static boolean solve() {
        try {
            int[] line0 = readInts();
            int n = line0[0], m = line0[1];
            Map<Integer, Set<Integer>> g = new HashMap<>();
            Set<Integer> seen = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                g.put(i, new HashSet<>());
            }
            for (int i = 0; i < m; i++) {
                int[] ab = readInts();
                g.get(ab[0]).add(ab[1]);
                g.get(ab[1]).add(ab[0]);
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (!seen.contains(i)) {
                    int[] x = dfs(g, seen, i);
                    if (x[0] > 1 && x[0] % 2 == 1 && 2 * x[0] == x[1]) {
                        ans++;
                    }
                }
            }
            if ((n - ans) % 2 == 1) {
                ans++;
            }
            System.out.println(ans);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        while (solve()) ;
    }
}