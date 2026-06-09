import java.util.*;
public class atcoder_ABC167_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        List<List<Integer>> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine().split(" ");
            List<Integer> row = new ArrayList<>();
            for (String s : input) {
                row.add(Integer.parseInt(s));
            }
            c.add(row);
        }

        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }

        List<List<Integer>> l = new ArrayList<>();
        Set<List<Integer>> rem = new HashSet<>();

        int ans = 0;

        outer:
        for (int i = 1; i <= n; i++) {
            for (List<Integer> combination : getCombinations(pre, i)) {
                l.add(combination);
            }
            for (int j = 1; j <= m; j++) {
                int ca = 0;
                for (List<Integer> combination : l) {
                    for (int k : combination) {
                        ca += c.get(k).get(j - 1);
                    }
                }
                if (ca < x) {
                    rem.add(combination);
                } else {
                    continue outer;
                }
            }
            if (!rem.isEmpty()) {
                l.removeAll(rem);
                rem.clear();
            }
            if (l.isEmpty()) {
                System.out.println(-1);
                break;
            }
        }

        int minAns = Integer.MAX_VALUE;
        for (List<Integer> combination : l) {
            int ca = 0;
            for (int k : combination) {
                ca += c.get(k).get(0);
            }
            if (ans == 0 || ca < ans) {
                ans = ca;
            } else {
                minAns = Math.min(minAns, ca);
            }
        }

        System.out.println(ans);
    }

    public static List<List<Integer>> getCombinations(int[] pre, int i) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(pre, 0, new ArrayList<>(), combinations, i);
        return combinations;
    }

    private static void backtrack(int[] pre, int start, List<Integer> combination, List<List<Integer>> combinations, int i) {
        if (combination.size() == i) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        for (int j = start; j < pre.length; j++) {
            combination.add(pre[j]);
            backtrack(pre, j + 1, combination, combinations, i);
            combination.remove(combination.size() - 1);
        }
    }
}