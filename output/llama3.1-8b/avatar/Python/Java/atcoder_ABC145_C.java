import java.util.*;
public class atcoder_ABC145_C {
    public static void solve(int N, int[] x, int[] y) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            indices.add(i);
        }
        List<List<Integer>> permutations = getPermutations(indices);
        double[] distances = new double[permutations.size()];
        for (int i = 0; i < permutations.size(); i++) {
            int totalDistance = 0;
            for (int j = 0; j < N - 1; j++) {
                int f = permutations.get(i).get(j);
                int t = permutations.get(i).get(j + 1);
                double distance = Math.sqrt(Math.pow(x[t] - x[f], 2) + Math.pow(y[t] - y[f], 2));
                totalDistance += distance;
            }
            distances[i] = (double) totalDistance / N;
        }
        double result = Arrays.stream(distances).average().getAsDouble();
        System.out.println(result);
    }

    public static List<List<Integer>> getPermutations(List<Integer> list) {
        if (list.size() == 1) {
            return new ArrayList<>(Collections.singletonList(list));
        }
        List<List<Integer>> permutations = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            List<Integer> rest = new ArrayList<>(list.subList(0, i));
            rest.addAll(list.subList(i + 1, list.size()));
            for (List<Integer> p : getPermutations(rest)) {
                List<Integer> permutation = new ArrayList<>();
                permutation.add(current);
                permutation.addAll(p);
                permutations.add(permutation);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        solve(N, x, y);
    }
}