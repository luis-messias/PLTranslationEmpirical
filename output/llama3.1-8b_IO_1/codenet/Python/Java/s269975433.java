import java.util.*;

public class s269975433 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Q = scanner.nextInt();

        List<List<Integer>> Q_groups = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            List<Integer> group = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                group.add(scanner.nextInt());
            }
            Q_groups.add(group);
        }

        int max_score = 0;
        for (List<Integer> p : combinationsWithReplacement(M, N)) {
            int temp_score = 0;
            for (List<Integer> q : Q_groups) {
                if (p.get(q.get(1) - 1) - p.get(q.get(0) - 1) == q.get(2)) {
                    temp_score += q.get(3);
                }
            }
            max_score = Math.max(max_score, temp_score);
        }

        System.out.println(max_score);
    }

    public static List<List<Integer>> combinationsWithReplacement(int n, int k) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(set, new ArrayList<>(), 1, n, k);
        return new ArrayList<>(set);
    }

    private static void backtrack(Set<List<Integer>> set, List<Integer> current, int start, int n, int k) {
        if (current.size() == k) {
            set.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(set, current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }

    public static int nextInt(Scanner scanner) {
        return scanner.nextInt();
    }
}
